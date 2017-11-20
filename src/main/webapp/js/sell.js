$(document).ready(function() {
    get_allDate();
});
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}
function get_allDate(type,date){
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
function buy(){
    var customerId = getQueryString("customerId");
    var obj = document.getElementsByName("checkBox");
    var packageInformationId = "";
    if($("input[name='checkBox']:checked").length >= 2 || $("input[name='checkBox']:checked").length == 0){
        alert("请选择一款套餐进行购买!");
    } else {
        for (k in obj) {
            if (obj[k].checked)
                packageInformationId = obj[k].value;
        }
        $.ajax({
            traditional : true,
            type : "post",
            url : "/zyhtweb/action/pack-pur-information!savePackPurInformation.do",
            dataType : "json",
            data : {"customerId":customerId,"packageInformationId":packageInformationId},
            success : function(data) {
                if (data.isSuccess){
                    alert("购买成功");
                    window.location = "/zyhtweb/action/pack-pur-information!findAllPackPurInformation.do?" + "customerId="+customerId;
                }else{
                    alert("购买失败,您的余额已不足请及时充值!!!");
                    window.location = "select.jsp"
                }
            },
            error : function(xhr, status, error) {
                alert(error);
            }
        });

    }
}