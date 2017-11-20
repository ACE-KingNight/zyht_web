<%--
  Created by IntelliJ IDEA.
  User: Wzx
  Date: 2017-09-25
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common_tag.jsp"%>

<link type="text/css" rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css">
<script src="<%=basePath%>/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script>

<html>
<head>
    <title>jstl显示客户套餐购买记录</title>
</head>
<body style="text-align: center">
    <div class="back" style="text-align: center;">
        <table id="myTb" class="table table-striped" style="text-align: center;border-collapse: separate;border-spacing: 20px">
            <thead>
            <tr>
                <%--<th><input type="text" hidden="hidden"></th>--%>
                <th>编号</th>
                <th>购买时间</th>
                <th>客户姓名</th>
                <th>套餐名</th>
                <th>支付金额</th>
                <th>是否支付成功</th>
                <th>执行时间</th>
            </tr>
            </thead>
            <c:forEach var="packPurInformationVoList" items="${packPurInformationVoList}" varStatus="varstatus">
                <tr>
                    <td>${varstatus.index+1}</td>
                    <td>${packPurInformationVoList.buyTimeStr}</td>
                    <td>${packPurInformationVoList.customerName}</td>
                    <td>${packPurInformationVoList.packageInformationName}</td>
                    <td><fmt:formatNumber value="${packPurInformationVoList.amountOfPayment}" pattern="##.##" type="CURRENCY"></fmt:formatNumber></td>
                    <td>${packPurInformationVoList.isSuccess}</td>
                    <td>${packPurInformationVoList.effectTimeStr}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div>
        <button id="insertBut" onclick="getback()" type="button" class="btn btn-success">返回</button>
    </div>
</body>
<script>
    function getback(){
        window.location="/zyhtweb/page/mobile_package/select.jsp";
    }
</script>
</html>
