
$(document).ready(function() {
    get_allDate();
});

function get_allDate(){
    $.ajax({
        type:"post",
        url:"/zyhtweb/action/package-information!findAllPackageInformation.do",
        data: {},
        dataType:"json",
        success:function(data){
            var tbBody = "";
            for (i=0;i<data.length;i++){
                tbBody = "<tr><td>"
                    + "<input name='checkBox' type='checkbox' value='"+data[i].id+"'>"+"</td>"
                + "<td>" + data[i].mealNumber + "</td>"
                + "<td>" + data[i].mealName + "</td>"
                + "<td>" + data[i].mealDescribe + "</td>"
                + "<td>" + data[i].messageNumber + "</td>"
                + "<td>" + data[i].minuteNumber + "</td>"
                + "<td>" + data[i].flowNumber + data[i].unit  + "</td>"
                + "<td>" + data[i].isCall + "</td>"
                + "<td>" + data[i].isColorBack + "</td>"
                + "<td>" + data[i].monthlyRent + "</td>"
                + "<td>" + data[i].mealStartDate + "</td>"
                + "<td>" + data[i].mealEndDate + "</td>"
                +"</tr>";
                $("#myTb").append(tbBody);
            }
        },
        error : function(error) {
            alert("错误");
        }
    });
}
function insert(){
    $("#submitBut").css("display","block");
    $("#ly").css("display","block");
    $("#insertDiv").css("display","block");
}
function insertSubmint(){
    var date = $("#insertForm").serialize();
    $.ajax({
        type:"post",
        url:"/zyhtweb/action/package-information!insertPackageInformation.do",
        data:date,
        dataType:"json",
        success:function(data){
            if(data != null){
                alert("插入成功");
                window.location.reload();
            }
        }, error:function() {
            alert("错误");
        }
    });
    $("#ly").css("display","none");
    $("#insertDiv").css("display","none");
}

function update(){
    var obj = document.getElementsByName("checkBox");
    var id = "";
    if($("input[name='checkBox']:checked").length >= 2 || $("input[name='checkBox']:checked").length == 0){
        alert("请选择一条数据进行修改!");
    } else {
        $("#updateSubmitBut").css("display","block");
        $("#ly").css("display","block");
        $("#insertDiv").css("display","block");
        for (k in obj) {
            if (obj[k].checked)
                id = obj[k].value;
        }
        $.ajax({
            type : "post",
            url : "/zyhtweb/action/package-information!findPackageInformation.do?",
            dataType : "json",
            data : {"id":id},
            success:function(data) {
                $("#mealNumber").val(data.mealNumber);
                $("#mealName").val(data.mealName);
                $("#mealDescribe").val(data.mealDescribe);
                $("#messageNumber").val(data.messageNumber);
                $("#minuteNumber").val(data.minuteNumber);
                $("#flowNumber").val(data.flowNumber);
                $("#monthlyRent").val(data.monthlyRent);
                $("#mealStartDate").val(data.mealStartDate);
                $("#mealEndDate").val(data.mealEndDate);
                if (data.isCall) {
                    $("#isCallYes").attr("checked", true);
                }else{
                    $("#isCallNo").attr("checked", true);
                }
                if (data.unit == "KB") {
                    $("#unitKB").attr("checked", true);
                }else if(data.unit == "MB"){
                    $("#unitMB").attr("checked", true);
                }else{
                    $("#unitGB").attr("checked", true);
                }
                if (data.isColorBack) {
                    $("#isColorBackYes").attr("checked", true);
                }else{
                    $("#isColorBackNo").attr("checked", true);
                }
            },
            error : function(xhr, status, error) {
                alert(error);
            }
        });

    }
}
function deleteFun(){
    var obj = document.getElementsByName("checkBox");
    var id = "";
    if($("input[name='checkBox']:checked").length >= 2 || $("input[name='checkBox']:checked").length == 0){
        alert("请选择一条数据进行删除!");
    } else {
        alert("是否确认删除");
        for (k in obj) {
            if (obj[k].checked)
                id = obj[k].value;
        }
        $.ajax({
            type:"post",
            url:"/zyhtweb/action/package-information!deletePackageInformation.do",
            data:{"id":id},
            dataType:"json",
            success:function(){
                window.location.reload();
            },
            error : function() {
                alert("错误");
            }
        });
    }

}
function closeTop(){
    $("#ly").css("display","none");
    $("#insertDiv").css("display","none");
}
function updateSubmit(){
    var obj = document.getElementsByName("checkBox");
    var id = "";
    for (k in obj) {
        if (obj[k].checked)
            id = obj[k].value;
    }
    $("#id").val(id);
    var date = $("#insertForm").serialize();
    $.ajax({
        type:"post",
        url:"/zyhtweb/action/package-information!updatePackageInformation.do",
        data:date,
        dataType:"json",
        success:function(data){
            alert(data);
            window.location.reload();
        },
        error : function() {
            alert("错误");
        }
    });
    $("#ly").css("display","none");
    $("#insertDiv").css("display","none");
}
