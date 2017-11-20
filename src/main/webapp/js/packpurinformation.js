$(document).ready(function() {
    var customerId = getQueryString("customerId");
    get_allDate(customerId);
});
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}
function get_allDate(customerId){
    $.ajax({
        type:"post",
        url:"/zyhtweb/action/pack-pur-information!findAllPackPurInformation.do",
        data: {"customerId":customerId},
        dataType:"json",
        success:function(data){
            var tbBody = "";
            for (i=0;i<data.length;i++){
                tbBody = "<tr><td>"
                + "<input name='customerId' hidden='hidden' type='text' value='"+customerId+"'>"+"</td>"
                + "<td>" + i + "</td>"
                + "<td>" + data[i].buyTimeStr + "</td>"
                + "<td>" + data[i].customerName + "</td>"
                + "<td>" + data[i].packageInformationName + "</td>"
                + "<td>" + data[i].amountOfPayment + "</td>"
                + "<td>" + data[i].isSuccess + "</td>"
                + "<td>" + data[i].effectTimeStr + "</td>"
                +"</tr>";
                $("#myTb").append(tbBody);
            }
        },
        error : function(error) {
            alert("错误");
        }
    });
}
function getback(){
    window.location="select.jsp";
}