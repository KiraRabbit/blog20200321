//隐藏错误提示框
/*$(".icons").css("display","none");
$(".input_warn").css("display","none");*/
/*$('#phone').val("");
//$('#auth_code').val("");  //验证码
$('#username').val("");
$('#password').val("");

var phone = $("#phone");
var username = $("#username");
var password = $("#password");
var passwordRepeat = $("#passwordRepeat");*/

//手机号输入框失去焦点
/*phone.blur(function () {
    var phone_value = phone.val();
    var pattren = /^1[345789]\d{9}$/;
    var phone_len = phone_value.length;
    if(phone_len === 0){
        phone_null.css("display","block");
        phone.removeClass("phone_success");
        phone.addClass("phone_error");
    }
    if(phone_len !== 0){
        if(!pattren.test(phone_value)){
            phone_error.css("display","block");
            phone.removeClass("phone_success");
            phone.addClass("phone_error");
        }
        if(pattren.test(phone_value)){
            phone.removeClass("phone_error");
            phone.addClass("phone_success");
        }
    }
});*/
















$("#register").on("click", function () {
    var phone = $("#phone").val();
    var username = $("#username").val();
    var password = $("#password").val();
    $.ajax('/register/newUser', {
        type: 'post',
        data: {
            "phone":phone,
            "userName":username,
            "password":password
        },
        success: function (data) {
            alert("注册成功")
        },
        error: function () {
            alert("注册失败");
        }
    });
});