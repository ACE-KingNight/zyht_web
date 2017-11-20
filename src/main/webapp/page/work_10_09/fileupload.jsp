<%--
  Created by IntelliJ IDEA.
  User: Wzx
  Date: 2017-10-09
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common_tag.jsp"%>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<%--action="<%=basePath%>/action/file-upload!upLoad.do"--%>
<form id="myForm" method="post">
    请选择需要上传的文件:<input type="file" name="file">
    <button type="button" onclick="upLoad()">上传</button>
</form>

<a href="<%=basePath%>/action/file-upload!downLoad.do?imageId=4"><img src="/zyhtweb/image/timg.jpg" alt="测试"/></a>
</body>
<script src="<%=basePath%>/js/jquery.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/js/packageinformation.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script>
<script>
    function upLoad(){
        var date=$("#myForm")[0];
        var formData = new FormData(date);
        $.ajax({
            type:"post",
            url:"/zyhtweb/action/file-upload!upLoad.do",
            data: formData,
            dataType:"json",
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success:function(){
                alert("jjjj");
            },
            error : function(error) {
                alert("错误");
            }
        });
    }
</script>
</html>
