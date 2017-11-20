<%@ page import="com.domain.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Wzx
  Date: 2017-09-25
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common_tag.jsp"%>
<html>
<head>
    <title>JSTL标签库</title>
</head>
<body>
<c:set var="name"  value="empty"></c:set>
<c:out value="${name}" default="李四"></c:out>
<c:remove var="name" ></c:remove>
<%
    List<Customer> customerList = new ArrayList<Customer>();
    Customer customer = new Customer();
    customer.setName("张三");
    customer.setBalance(333d);
    customer.setSex("男");
    customerList.add(customer);
    Customer customer2 = new Customer();
    customer2.setName("张四");
    customer2.setBalance(333d);
    customer2.setSex("男");
    customerList.add(customer2);
    Customer customer3 = new Customer();
    customer3.setName("张四");
    customer3.setBalance(333d);
    customer3.setSex("男");
    customerList.add(customer3);
    Customer customer4 = new Customer();
    customer4.setName("张四");
    customer4.setBalance(333d);
    customer4.setSex("男");
    customerList.add(customer4);
    Customer customer5 = new Customer();
    customer5.setName("张四");
    customer5.setBalance(333d);
    customer5.setSex("男");
    customerList.add(customer5);
    session.setAttribute("customerList", customerList);
%>
<c:if test="${not empty customer}">
    <br><c:out value="${customer.name}"></c:out>
    <c:choose>
        <c:when test="${customer.balance > 500}">
            <h1>欢迎</h1>
        </c:when>
        <c:otherwise>
            <h1>穷逼,快滚</h1>
        </c:otherwise>
    </c:choose>
</c:if>
<c:if test="${empty customer}">
    <h1>
        没这个人
    </h1>
</c:if>
<table style="border: solid 1px #000000">
    <tr style="border: solid 1px #000000">
        <th style="border: solid 1px #000000">姓名</th>
        <th style="border: solid 1px #000000">性别</th>
        <th style="border: solid 1px #000000">余额</th>
    </tr>
<c:forEach var="customer" items="${customerList}" varStatus="varstatus">
    <tr style="border: solid 1px #000000">
        <c:choose>
            <c:when test="${varstatus.index+1 eq 2}">
                <c:choose>
                    <c:when test="${(varstatus.index+1) mod 2 eq 0}">
                        <td  style="background-color: #ffff00;border: solid 1px #000000">${customer.name}</td>
                        <td  style="background-color: #ffff00;border: solid 1px #000000">${customer.sex}</td>
                        <td rowspan="2" style="background-color: #ffff00;border: solid 1px #000000">${customer.balance}</td>
                    </c:when>
                    <c:otherwise>
                        <td  style="background-color: red;border: solid 1px #000000">${customer.name}</td>
                        <td  style="background-color: red;border: solid 1px #000000">${customer.sex}</td>
                        <td rowspan="2" style="background-color: red;border: solid 1px #000000">${customer.balance}</td>
                    </c:otherwise>
                </c:choose>
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${(varstatus.index+1) mod 2 eq 0}">
                        <td style="background-color: #ffff00;border: solid 1px #000000">${customer.name}</td>
                        <td style="background-color: #ffff00;border: solid 1px #000000">${customer.sex}</td>
                        <td style="background-color: #ffff00;border: solid 1px #000000">${customer.balance}</td>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${varstatus.index+1 eq 3}">
                                <td colspan="2" style="background-color:red;border: solid 1px #000000">${customer.name}</td>
                                <td style="background-color:red;border: solid 1px #000000">${customer.sex}</td>
                                <td style="background-color:red;border: solid 1px #000000">${customer.balance}</td>
                            </c:when>
                            <c:otherwise>
                                <td style="background-color:red;border: solid 1px #000000">${customer.name}</td>
                                <td style="background-color:red;border: solid 1px #000000">${customer.sex}</td>
                                <td style="background-color:red;border: solid 1px #000000">${customer.balance}</td>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
    </tr>
</c:forEach>
</table>
</body>
</html>
