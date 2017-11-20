<%@ page language="java" import="java.util.*,com.tag.*"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.jake.com" prefix="cc"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->
</head>

<body>
<!-- 创建需要展现UserInfo的实例（用于测试数据） -->

<%
    UserInfo user = new UserInfo();
    user.setUserName("Xuwei");
    user.setAge(33);
    user.setEmail("test@test.test");
    pageContext.setAttribute("userinfo", user);
    pageContext.setAttribute("date", new Date());

    Map<String, Object> map = new HashMap<String, Object>();
    map.put("xiaoxue", "小学");
    map.put("chuzhong", "初中");
    map.put("gaozhong", "高中");
    map.put("daxue", "大学");
    pageContext.setAttribute("map", map);

    List<UserInfo> users = new ArrayList<UserInfo>();
    users.add(new UserInfo("Zhangsan", 12, "Zhangsan@163.com"));
    users.add(new UserInfo("Lisi", 22, "Lisi@sina.com"));
    users.add(new UserInfo("Wangwu", 33, "Wangwu@qq.com"));
    pageContext.setAttribute("users", users);
%>
<cc:showUserInfo user="${pageScope.userinfo }" />


<c:set var="dt" value="2016-08-10 22:33:45" scope="session" />
当前日期:
<cc:dateTime value="${pageScope.date}" />
<br> 初始化格式时间:
<cc:dateTime value="${pageScope.date}" newFormat="yyyy-MM-dd HH:mm:ss"></cc:dateTime><br>
<cc:dateTime value="${pageScope.date}" newFormat="yyyy-MM-dd HH:mm:ss">执行标签体里面的内容</cc:dateTime><br>

<cc:mappingLabel value="1"
                 mappingString="0:总行,1:一级分行,2:二级分行,3:支行,4:网点,9:部门"></cc:mappingLabel>
<br> 学历:
<cc:commonSelect name="xueli" mappingItem="${pageScope.map }"
                 checkedValue="gaozhong" style="width:150px;" />

<!-- 给标签绑定数据源  -->

<table width='500px' border='1' align='center'>
    <tr>
        <td width='20%'>UserName</td>
        <td width='20%'>Age</td>
        <td>Email</td>
    </tr>
    <cc:repeater var="item" items="${pageScope.users }">
        <tr>
            <td>${item.userName }</td>
            <td>${item.age }</td>
            <td>${item.email }</td>
        </tr>
    </cc:repeater>

</table>

${cc:formatMyName("wangfei") }
<br> ${cc:add(12, 34) }
<br>
</body>
</html>
