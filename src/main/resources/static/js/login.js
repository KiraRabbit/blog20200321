$("#login").on("click", function () {
    var userName = $('#Username').val();
    var password = $('#Password').val();
    //正则匹配
    var namePattern = /^[a-zA-Z0-9_-]{4,16}$/;
    if (namePattern.test(userName)){
        $.ajax('/login/user', {
            dataType: 'json',
            type: 'POST',
            data: {"userName":userName,
                "password":password,
            },
            success: function (data) {
                if (data.code == 200) {
                    toastr["success"]('登录成功');
                    //跳转后台管理页面
                    window.location.href = "../manager.html";
                } else if (data.code == 400){
                    toastr["error"]('登录失败');
                }
            },
            error: function (_error) {
                toastr["error"]('登录异常');
            }
        });
    }else {
        toastr["error"]('用户名格式错误');
    }



});