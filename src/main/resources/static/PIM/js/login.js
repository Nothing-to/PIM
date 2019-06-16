$(document).ready(function () {
    $("#login").click(function () {
        var userId = $("#userId").val();
        var password = $("#password").val();
        if (!userId) {
            $("p#message").html("请输入账号");
            $("#mypopup").popup('open');
            $("#userId").focus();
            setTimeout(function () {
                $("#mypopup").popup('close');
            },1000);
            return false;
        }else if (!password) {
            $("p#message").html("请输入密码");
            $("#mypopup").popup('open');
            setTimeout(function () {
                $("#mypopup").popup('close');
                $("#password").focus();
            },1000);
            return false;
        }
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/PIM/checkLogin",
            data: JSON.stringify({userId:userId,password:password}),
            dataType: 'json',
            success: function (result) {
                if (result.code==100) {
                    window.location.href = "/PIM/mainPage";
                } else {
                    alert(result.extendInfo.login_error);
                }
            },
            error: function () {
                alert("未知异常！！");
            }
        });
    });
});