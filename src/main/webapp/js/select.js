$(function(){
    $("#but1").click(function(){
        var id = $("#ID").val();
        $.ajax({
            type:"post",
            url:"/zyhtweb/action/customer!findCustomer.do",
            data: {"id":id},
            dataType:"json",
            success:function(data){
                $("#delete").css("display","none");
                $("#update").css("display","block");
                $("#packpurinformation").css("display","none");
                $("#tellphone").css("display","none");
                $("#sell").css("display","none");
                $("#submit").css("display","block");
                $("#reset").css("display","block");
                var customer = data;
                $("#name").val(customer.name);
                $("#name").removeAttr("readonly");
                if (customer.sex == "男") {
                    $("#sex").attr("checked", "checked");
                    $("#sex").prop("checked");
                    $("#sex").attr("disabled", false);
                } else {
                    $("#sex1").attr("checked", "checked");
                    $("#sex1").prop("checked");
                    $("#sex1").attr("disabled", false);
                }
                $("#idCard").val(customer.idCard);
                $("#idCard").removeAttr("readonly");
                $("#phoneCode").val(customer.phoneCode);
                $("#phoneCode").removeAttr("readonly");
                $("#address").val(customer.address);
                $("#address").removeAttr("readonly");
                $("#balance").val(customer.balance);
                $("#balance").removeAttr("readonly");
                $("#idUpdate").val(customer.id);
                $("#idUpdate").removeAttr("readonly");
            },error:function(error){
                alert("com.aaa");
            }
        })
    });
    $("#but2").click(function(){
        var id = $("#ID").val();
        $.ajax({
            type:"post",
            url:"/zyhtweb/action/customer!findCustomer.do",
            data: {"id":id},
            dataType:"json",
            success:function(data){
                $("#delete").css("display","none");
                $("#submit").css("display","none");
                $("#reset").css("display","none");
                $("#update").css("display","block");
                $("#packpurinformation").css("display","block");
                $("#tellphone").css("display","block");
                $("#sell").css("display","block");
                var customer = data;
                $("#name").val(customer.name);
                $("#name").attr("readonly", true);
                if (customer.sex == "男") {
                    $("#sex").attr("checked", "checked");
                    $("#sex").prop("checked");
                    $("#sex").attr("disabled", true);
                } else {
                    $("#sex1").attr("checked", "checked");
                    $("#sex1").prop("checked");
                    $("#sex1").attr("disabled", true);
                }
                $("#idCard").val(customer.idCard);
                $("#idCard").attr("readonly", true);
                $("#phoneCode").val(customer.phoneCode);
                $("#phoneCode").attr("readonly", true);
                $("#address").val(customer.address);
                $("#address").attr("readonly", true);
                $("#balance").val(customer.balance);
                $("#balance").attr("readonly", true);
                $("#idUpdate").val(customer.id);
            },error:function(error){
                alert("com.aaa");
            }
        })
    });
    $("#but3").click(function(){
        var id = $("#ID").val();
        $.ajax({
            type:"post",
            url:"/zyhtweb/action/customer!findCustomer.do",
            data: {"id":id},
            dataType:"json",
            success:function(data){
                $("#submit").css("display","none");
                $("#reset").css("display","none");
                $("#delete").css("display","block");
                $("#update").css("display","block");
                $("#packpurinformation").css("display","none");
                $("#tellphone").css("display","none");
                $("#sell").css("display","none");
                var customer = data;
                $("#name").val(customer.name);
                $("#name").attr("readonly", true);
                if (customer.sex == "男") {
                    $("#sex").attr("checked", "checked");
                    $("#sex").prop("checked");
                    $("#sex").attr("disabled", true);
                } else {
                    $("#sex1").attr("checked", "checked");
                    $("#sex1").prop("checked");
                    $("#sex1").attr("disabled", true);
                }
                $("#idCard").val(customer.idCard);
                $("#idCard").attr("readonly", true);
                $("#phoneCode").val(customer.phoneCode);
                $("#phoneCode").attr("readonly", true);
                $("#address").val(customer.address);
                $("#address").attr("readonly", true);
                $("#balance").val(customer.balance);
                $("#balance").attr("readonly", true);
                $("#idUpdate").val(customer.id);
            },error:function(error){
                alert("com.aaa");
            }
        })
    });
    $("#delete").click(function(){
        var id = $("#ID").val();
        $.ajax({
            type:"post",
            url:"/zyhtweb/action/customer!deleteCustomer.do",
            data: {"id":id},
            dataType:"json",
            success:function(data){
                alert(data);
                window.location.reload();
            },error:function(error){
                alert("com.aaa");
            }
        })
    });
    $("#packpurinformation").click(function(){
        var id = $("#ID").val();
        //window.location="packpurinformation.jsp?"+"customerId="+id;
        window.open("/zyhtweb/action/pack-pur-information!findAllPackPurInformation.do?customerId="+id);
    });
    $("#tellphone").click(function(){
        var id = $("#ID").val();
        window.location="/zyhtweb/action/customer!call.do?customerId="+id;
    });
    $("#sell").click(function(){
        var id = $("#ID").val();
        window.location="sell.jsp?"+"customerId="+id;
    });
});
function validateForm(){
    var name=document.forms["myForm"]["name"].value;
    if (name==null || name==""){
        alert("姓必须填写");
        return false;
    }
    var idCard = document.forms["myForm"]["idCard"].value;
    var emailreg = /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/;
    if (idCard==null || idCard ==""){
        alert("请输入身份证号!");
        return false;
    }else if(!emailreg.test(idCard)){
        alert("请输入正确的身份证号!");
        return false;
    }
    var phone = document.forms["myForm"]["phoneCode"].value;
    var phonereg = /^1(3|4|5|7|8)\d{9}$/;
    if(phone ==null || phone==""){
        alert("请输入手机号!");
        return false;
    }else if(phone.length != 11){
        alert("请输入正确的手机号!");
        return false;
    }else if(!phonereg.test(phone)){
        alert("请输入正确的手机号111!");
        return false;
    }
    var birthday = document.forms["myForm"]["address"].value;
    if(birthday == null || birthday == ""){
        alert("请输入地址!!!");
        return false;
    }
    return true;
}