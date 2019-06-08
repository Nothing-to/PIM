$(document).ready(function(){
$("#slider").change(function(){
    if($(this).val()=="yes"){
        $("#submit").removeAttr("disabled");
        $("#submit").button("refresh");
    }else{
        $("#submit").attr({"disabled":"disabled"});
        $("#submit").button("refresh");
    }
});

$("#formRegister").on("submit",function(){

    if($("#name").val()==""){
        $("p#message").html("请输入账号");
        $("#mypopup").popup('open');
        return false;
    }

    if($("#pwd").val()==""){
        $("p#message").html("请输入密码");
        $("#mypopup").popup('open');
        return false;
    }
    if($("#pwd").val()!=$("#qpwd").val()){
        $("p#message").html("密码和确认密码不一致");
        $("#mypopup").popup('open');
        return false;
    }
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/register",
        data: JSON.stringify({userId:$("#name").val(),password:$("#pwd").val()}),
        dataType: "json",
        success: function(data){
            if (data.code==100){
                alert("注册成功！");
                location.href="/Login";
            }else {
                $("p#message").html(data.extendInfo.register_error);
                $("#mypopup").popup('open');
            }
        },
        error:function()
        {
            alert("error!!");
        }
    });
});
});