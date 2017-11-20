<%--
  Created by IntelliJ IDEA.
  User: Wzx
  Date: 2017-09-20
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="../common_tag.jsp"%>

<link type="text/css" rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css">


<%--<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

<html>
<head>
    <title>套餐信息</title>
    <meta charset="UTF-8"/>
</head>
<body>
<div id="insertDiv" style="margin-top: 5%;position:fixed;margin-left: 200px;display: none;z-index: 5;width: 1000px;height: 700px;">
    <form id="insertForm" class="form-horizontal" role="form">
        <div class="form-group">
            <label for="mealNumber" class="col-sm-2 control-label">套餐编号</label>
            <div class="col-sm-4">
                <input type="text" name="mealNumber" class="form-control" id="mealNumber" placeholder="请输入套餐编号">
            </div>
            <label class="col-sm-2 control-label">是否有来显</label>
            <label class="radio-inline" style="float: left">
                <input type="radio" name="isCall" id="isCallYes" value="true" checked>是
            </label>
            <label class="radio-inline" style="float: left">
                <input type="radio" name="isCall" id="isCallNo"  value="false">否
            </label>
        </div>
        <div class="form-group">
            <label for="mealName" class="col-sm-2 control-label">套餐名</label>
            <div class="col-sm-4">
                <input type="text" name="mealName" class="form-control" id="mealName" placeholder="请输入套餐名">
            </div>
            <label class="col-sm-2 control-label">是否有彩铃</label>
            <label class="radio-inline" style="float: left">
                <input type="radio" name="isColorBack" id="isColorBackYes" value="true" checked>是
            </label>
            <label class="radio-inline" style="float: left">
                <input type="radio" name="isColorBack" id="isColorBackNo"  value="false">否
            </label>
        </div>
        <div class="form-group">
            <label for="mealDescribe" class="col-sm-2 control-label">套餐描述</label>
            <div class="col-sm-4">
                <input type="text" name="mealDescribe" class="form-control" id="mealDescribe" placeholder="请输入套餐描述">
            </div>
            <label for="monthlyRent" class="col-sm-2 control-label">月租</label>
            <div class="col-sm-5">
                <input type="text" name="monthlyRent" class="form-control" id="monthlyRent" placeholder="请输入月租">
            </div>
        </div>
        <div class="form-group">
            <label for="messageNumber" class="col-sm-2 control-label">短信数</label>
            <div class="col-sm-4">
                <input type="text" name="messageNumber" class="form-control" id="messageNumber" placeholder="请输入短信数">
            </div>
            <label for="mealStartDate" class="col-sm-2 control-label">套餐开始时间</label>
            <div class="col-sm-5">
                <input type="date" name="mealStartDate" class="form-control" id="mealStartDate" placeholder="请输入套餐名">
            </div>
        </div>
        <div class="form-group">
            <label for="minuteNumber" class="col-sm-2 control-label">通话时长</label>
            <div class="col-sm-4">
                <input type="text" name="minuteNumber" class="form-control" id="minuteNumber" placeholder="请输入通话时长">
            </div>
            <label for="mealEndDate" class="col-sm-2 control-label">套餐结束时间</label>
            <div class="col-sm-5">
                <input type="date" name="mealEndDate" class="form-control" id="mealEndDate" placeholder="请输入套餐名">
            </div>
        </div>
        <div class="form-group">
            <label for="flowNumber" class="col-sm-2 control-label">流量</label>
            <div class="col-sm-4">
                <input type="text" name="flowNumber" class="form-control" id="flowNumber" placeholder="请输入流量数">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">流量单位</label>
            <label class="radio-inline" style="float: left">
                <input type="radio" name="unit" id="unitKB" value="KB" >KB
            </label>
            <label class="radio-inline" style="float: left">
                <input type="radio" name="unit" id="unitMB"  value="MB" checked>MB
            </label>
            <label class="radio-inline" style="float: left">
                <input type="radio" name="unit" id="unitGB"  value="GB">GB
            </label>
            <input id="id" name="id" type="text" hidden="hidden"/>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-5">
                <button style="display: none" type="button" onclick="insertSubmint()" class="btn btn-default" id="submitBut">提交</button>
                <button style="display: none" type="button" onclick="updateSubmit()" class="btn btn-default" id="updateSubmitBut">修改</button>
                <button type="reset" id="resetBut" class="btn btn-default">重置</button>
                <button onclick="closeTop()" id="closeBut" class="btn btn-default">关闭</button>
            </div>
        </div>
    </form>
</div>
<div class="back" style="text-align: center;">
    <table id="myTb" class="table table-striped" style="text-align: center;border-collapse: separate;border-spacing: 20px">
        <thead>
        <tr>
            <th><input type="checkbox" hidden="hidden"></th>
            <th>套餐编号</th>
            <th>套餐名</th>
            <th>套餐描述</th>
            <th>短信数</th>
            <th>通话时长</th>
            <th>流量</th>
            <th>是否有彩铃</th>
            <th>是否有来电显示</th>
            <th>月租</th>
            <th>套餐开始时间</th>
            <th>套餐结束时间</th>
        </tr>
        </thead>
    </table>
    <div>
        <button id="insertBut" onclick="insert()" type="button" class="btn btn-success">添加</button>
        <button id="updateBut" onclick="update()" type="button" class="btn btn-warning">修改</button>
        <button id="deleteBut" onclick="deleteFun()" type="button" class="btn btn-danger">删除</button>
    </div>
</div>
<div id="ly"
     style="position: fixed; top: 0; left: 0; z-index: 2; width: 100%; height: 100%; background: rgba(110, 220, 61, 0.41); filter: alpha(opacity = 70); opacity: 0.7; display: none;">
</div>
<script src="<%=basePath%>/js/jquery.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/js/packageinformation.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script>
</body>
</html>