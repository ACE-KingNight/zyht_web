function tell(){
    $("#callForm").css("display","block");
}

var hour,minute,second;//时 分 秒
hour=minute=second=0;//初始化
var int;

function start()//开始
{
    int=setInterval(timer,1000);
    var callCustomerId = getQueryString("customerId");
    var answerCustomerId = $("#answerCustomerId").val();
    $.ajax({
        type:"post",
        url:"/zyhtweb/action/call!insertCall.do",
        data:{"callCustomerId":callCustomerId,"answerCustomerId":answerCustomerId},
        dataType:"json",
        success:function(date){
            $("#callRecordId").val(date[0]);
            $("#answerRecordId").val(date[1]);
        },error:function(){
            alert("错误");
        }
    });
}
function Reset()//重置
{
    window.clearInterval(int);
    hour=minute=second=0;
    //document.getElementById('timer').value='00:00:00';

}
function timer()//计时
{
    second = second + 1;
    if(second>=60)
    {
        second=0;
        minute=minute+1;
    }

    if(minute>=60)
    {
        minute=0;
        hour=hour+1;
    }
    document.getElementById('timer').value=hour+':'+minute+':'+second;

}

function stop()//暂停
{
    //window.clearInterval(int);
    setTimeout(Reset,3);
    var callRecordId = $("#callRecordId").val();
    var answerRecordId = $("#answerRecordId").val();
    $.ajax({
        type:"post",
        url:"/zyhtweb/action/call!updateCall.do",
        data:{"callRecordId":callRecordId,"answerRecordId":answerRecordId},
        dataType:"json",
        success:function(date){
            alert(date);
            location.reload();
        },error:function(){
            alert("错误");
        }
    });

}

function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}

/**
 * 对Date的扩展，将 Date 转化为指定格式的String
 * 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
 * 如:
 * (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
 * (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
 * (new Date(date.time)).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
 */
Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "H+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

function sendMessages(){
    var messages = $("#messages").val();
    var callCustomerId = getQueryString("customerId");
    var receiveCustomerId = $("#receiveCustomerId").val();
    $.ajax({
        type:"post",
        url:"/zyhtweb/action/messages!sendMessage.do",
        data:{"callCustomerId":callCustomerId,"answerCustomerId":receiveCustomerId,
            "messages":messages},
        dataType:"json",
        success:function(date){
            if(date == "发送成功"){
                alert(date);
                location.reload();
            }
        },error:function(){
            alert("错误");
        }
    });
}

function callLogs(){
    var customerId = getQueryString("customerId");
    $.ajax({
        type:"post",
        url:"/zyhtweb/action/call-records!findCallRecords.do",
        data:{"customerId":customerId},
        dataType:"json",
        success:function(data){
            var tbBody = "";
            $(".tr").remove();
            for (i=0;i<data.length;i++){
                tbBody = "<tr class='tr'><td>";
                if (data[i].callCustomer.id == customerId) {
                    tbBody = tbBody + data[i].answerCustomer.name + "</td>";
                } else if (data[i].answerCustomer.id == customerId) {
                    tbBody = tbBody + data[i].callCustomer.name + "</td>";
                }
                tbBody = tbBody + "<td>" + data[i].callDuration+"秒" + "</td>"
                + "<td>" + data[i].consumption+ "元" + "</td>"
                + "<td>" + data[i].startTime + "</td>"
                + "<td>" + data[i].endTime + "</td>"
                + "<td>" + data[i].isAnswer + "</td>";
                if(data[i].dialType == 1){
                    tbBody = tbBody + "<td>" + "呼出" + "</td>";
                }else{
                    tbBody = tbBody + "<td>" + "呼入" + "</td>";
                }
                tbBody = tbBody +"</tr>";
                $("#myCallTb").append(tbBody);
            }
        },error:function(){
            alert("错误");
        }
    });
}

function messagelogs(){
    var customerId = getQueryString("customerId");
    $.ajax({
        type:"post",
        url:"/zyhtweb/action/message-records!findMessageRecords.do",
        data:{"customerId":customerId},
        dataType:"json",
        success:function(data){
            var tbBody = "";
            $(".tr").remove();
            for (i=0;i<data.length;i++){
                tbBody = "<tr class='tr'><td>";
                if (data[i].sendCustomer.id == customerId) {
                    tbBody = tbBody + data[i].receiveCustomer.name + "</td>";
                } else if (data[i].receiveCustomer.id == customerId) {
                    tbBody = tbBody + data[i].sendCustomer.name + "</td>";
                }
                tbBody = tbBody + "<td>" + data[i].sendTime + "</td>"
                + "<td>" + data[i].receiveTime+ "</td>"
                + "<td>" + data[i].isReceive + "</td>";
                if(data[i].messagesType == 1){
                    tbBody = tbBody + "<td>" + "短信" + "</td>";
                }else{
                    tbBody = tbBody + "<td>" + "彩信" + "</td>";
                }
                if(data[i].customerType == 1){
                    tbBody = tbBody + "<td>" + "发送" + "</td>";
                }else{
                    tbBody = tbBody + "<td>" + "接收" + "</td>";
                }
                tbBody = tbBody + "<td>" + data[i].messageContent +"</td>";
                tbBody = tbBody +"</tr>";
                $("#myMessageTb").append(tbBody);
            }
        },error:function(){
            alert("错误");
        }
    });
}