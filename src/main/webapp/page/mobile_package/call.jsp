<%--
  Created by IntelliJ IDEA.
  User: Wzx
  Date: 2017-09-26
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common_tag.jsp"%>

<link type="text/css" rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css">
<script src="<%=basePath%>/js/jquery.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/js/call.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script>

<html>
<head>
    <title>拨打电话</title>
</head>
<body style="text-align: center">
<div style="margin-left: 30%;margin-top: 5%;max-width: 500px">

        <button id="callBut" style="margin-top: 3%" type="button" class="btn btn-success btn-lg btn-block" data-toggle="collapse"
                data-target="#callDiv">
            我要打电话
        </button>
    <div id="callDiv" class="collapse">
        <form id="callForm" style="display: block" role="form">
            <div class="form-group">
             <h3><label>请选择拨打者</label></h3>
                <select id="answerCustomerId" class="form-control">
                <c:forEach var="customer" items="${customerList}">
                    <option value="${customer.id}">${customer.name}:${customer.phoneCode}</option>
                </c:forEach>
                </select>
            </div>
            <h3><label>通话时长:</label></h3>
            <strong><input style="text-align: center;font-size: 25px" readonly id="timer" type="text" class="form-control"/></strong>
            <input style="display: none" type="text" id="startTime">
            <input type="text" style="display: none" id="callRecordId">
            <input type="text" style="display: none" id="answerRecordId">
            <button type="button" style="margin-top: 2%" id="startCall" onclick="start()" class="btn btn-success">开始通话</button>
            <input style="display: none" type="text" id="endTime">
            <button type="button" style="margin-top: 2%" id="endCall" onclick="stop()" class="btn btn-danger">结束通话</button>
        </form>
    </div>
    <button id="sendBut" style="margin-top: 3%" type="button" class="btn btn-info btn-lg btn-block" data-toggle="collapse"
            data-target="#sendMessage">
        我要发短信
    </button>
    <div id="sendMessage" class="collapse">
        <form id="sendForm" style="display: block" role="form">
            <div class="form-group">
                <h3><label>请选择要发送的人</label></h3>
                <select id="receiveCustomerId" class="form-control">
                    <c:forEach var="customer" items="${customerList}">
                        <option value="${customer.id}">${customer.name}:${customer.phoneCode}</option>
                    </c:forEach>
                </select>
                <h3><label>短信内容</label></h3>
                <textarea id="messages" class="form-control" rows="3"></textarea>
            </div>
            <button type="button" style="margin-top: 2%" onclick="sendMessages()" id="sendMessageBut" class="btn btn-success">确认发送</button>
            <button type="reset" style="margin-top: 2%"  class="btn btn-warning">重新输入</button>
        </form>
    </div>
    <button id="call_logs_but" onclick="callLogs()" style="margin-top: 3%" type="button" class="btn btn-success btn-lg btn-block" data-toggle="collapse"
            data-target="#call_logs_div">
        通话记录
    </button>
</div>
<div style="max-width: 1000px;width: 1000px;margin-left: 15%" id="call_logs_div" class="collapse">
    <table id="myCallTb" class="table table-striped" style="text-align: center;border-collapse: separate;border-spacing: 20px">
        <thead>
        <tr>
            <th>通话对象</th>
            <th>通话时长</th>
            <th>通话费用</th>
            <th>通话开始时间</th>
            <th>通话结束时间</th>
            <th>是否应答</th>
            <th>通话类型</th>
        </tr>
        </thead>
    </table>
</div>
<div style="margin-left: 30%;margin-top: 1%;max-width: 500px">
    <button id="message_logs_but" onclick="messagelogs()" style="margin-top: 3%" type="button" class="btn btn-info btn-lg btn-block"
            data-toggle="collapse"
            data-target="#message_logs_div">
        短信记录
    </button>
</div>
<div style="max-width: 1000px;width: 1000px;margin-left: 15%" id="message_logs_div" class="collapse">
    <table id="myMessageTb" class="table table-striped" style="text-align: center;border-collapse: separate;border-spacing: 20px">
        <thead>
        <tr>
            <th>短信对象</th>
            <th>短信发送时间</th>
            <th>短信接收时间</th>
            <th>是否接收</th>
            <th>短信类型</th>
            <th>客户类型</th>
            <th>短信内容</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>
