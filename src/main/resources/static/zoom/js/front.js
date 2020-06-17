var tests;
$(function () {

    // ------------------------------------------------------- //
    // Tooltips init
    // ------------------------------------------------------ //    

    $('[data-toggle="tooltip"]').tooltip();

    // ------------------------------------------------------- //
    // Universal Form Validation
    // ------------------------------------------------------ //

    $('.form-validate').each(function () {
        $(this).validate({
            errorElement: "div",
            errorClass: 'is-invalid',
            validClass: 'is-valid',
            ignore: ':hidden:not(.summernote),.note-editable.card-block',
            errorPlacement: function (error, element) {
                // Add the `invalid-feedback` class to the error element
                error.addClass("invalid-feedback");
                //console.log(element);
                if (element.prop("type") === "checkbox") {
                    error.insertAfter(element.siblings("label"));
                } else {
                    error.insertAfter(element);
                }
            }
        });
    });

    // ------------------------------------------------------- //
    // Material Inputs
    // ------------------------------------------------------ //

    var materialInputs = $('input.input-material');

    // activate labels for prefilled values
    materialInputs.filter(function () {
        return $(this).val() !== "";
    }).siblings('.label-material').addClass('active');

    // move label on focus
    materialInputs.on('focus', function () {
        $(this).siblings('.label-material').addClass('active');
    });

    // remove/keep label on blur
    materialInputs.on('blur', function () {
        $(this).siblings('.label-material').removeClass('active');

        if ($(this).val() !== '') {
            $(this).siblings('.label-material').addClass('active');
        } else {
            $(this).siblings('.label-material').removeClass('active');
        }
    });

    // ------------------------------------------------------- //
    // Footer 
    // ------------------------------------------------------ //   

    var pageContent = $('.page-content');

    $(document).on('sidebarChanged', function () {
        adjustFooter();
    });

    $(window).on('resize', function () {
        adjustFooter();
    })

    function adjustFooter() {
        var footerBlockHeight = $('.footer__block').outerHeight();
        pageContent.css('padding-bottom', footerBlockHeight + 'px');
    }

    // ------------------------------------------------------- //
    // Adding fade effect to dropdowns
    // ------------------------------------------------------ //
    $('.dropdown').on('show.bs.dropdown', function () {
        $(this).find('.dropdown-menu').first().stop(true, true).fadeIn(100).addClass('active');
    });
    $('.dropdown').on('hide.bs.dropdown', function () {
        $(this).find('.dropdown-menu').first().stop(true, true).fadeOut(100).removeClass('active');
    });


    // ------------------------------------------------------- //
    // Search Popup
    // ------------------------------------------------------ //
    $('.search-open').on('click', function (e) {
        e.preventDefault();
        $('.search-panel').fadeIn(100);
    })
    $('.search-panel .close-btn').on('click', function () {
        $('.search-panel').fadeOut(100);
    });


    // ------------------------------------------------------- //
    // Sidebar Functionality
    // ------------------------------------------------------ //
    $('.sidebar-toggle').on('click', function () {
        $(this).toggleClass('active');

        $('#sidebar').toggleClass('shrinked');
        $('.page-content').toggleClass('active');
        $(document).trigger('sidebarChanged');

        if ($('.sidebar-toggle').hasClass('active')) {
            $('.navbar-brand .brand-sm').addClass('visible');
            $('.navbar-brand .brand-big').removeClass('visible');
            $(this).find('i').attr('class', 'fa fa-long-arrow-right');
        } else {
            $('.navbar-brand .brand-sm').removeClass('visible');
            $('.navbar-brand .brand-big').addClass('visible');
            $(this).find('i').attr('class', 'fa fa-long-arrow-left');
        }
    });


    // ------------------------------------------------------ //
    // For demo purposes, can be deleted
    // ------------------------------------------------------ //

    if ($('#style-switch').length > 0) {
        var stylesheet = $('link#theme-stylesheet');
        $("<link id='new-stylesheet' rel='stylesheet'>").insertAfter(stylesheet);
        var alternateColour = $('link#new-stylesheet');

        if ($.cookie("theme_csspath")) {
            alternateColour.attr("href", $.cookie("theme_csspath"));
        }

        $("#colour").change(function () {

            if ($(this).val() !== '') {

                var theme_csspath = 'css/style.' + $(this).val() + '.css';

                alternateColour.attr("href", theme_csspath);

                $.cookie("theme_csspath", theme_csspath, {
                    expires: 365,
                    path: document.URL.substr(0, document.URL.lastIndexOf('/'))
                });

            }

            return false;
        });
    }

});

$("#signUp").on("click", function () {
    var userName = $('#login-username').val();
    var password = $('#login-password').val();
    //正则匹配
    //var namePattern = /^[a-zA-Z0-9_-]{4,16}$/;
    //校验用户名，校验要求用户名字符长度6~18个字符，首字符必须为英文字母，其它字符范围为数字或英文字母或下划线
    var namePattern = /^[a-zA-Z]\w{5,17}$/;
    //if (namePattern.test(userName))
    var jsonData = $('#login-form').serialize();

    $.ajax('/login/user', {
        dataType: 'json',
        type: 'POST',
        async: true,
        data: jsonData,
        success: function (data) {
            tests = data;
            if (data.code == 200) {
                alert("登录中,请稍后");
                window.location.href="index.html";
            } else {
                alert("登录异常");
            }
        },
        error: function (data) {
            alert("登录异常");
        }
    });
    return false;
});




//用户注册

$("#register").on("click", function () {
    var userName = $('#register-username').val();
    var phone = $('#register-phoneNum').val();
    var trueName = $('#register-truename').val();
    var email = $('#register-email').val();
    var password = $('#register-password').val();
    var repeatassword = $('#repeat-password').val();
    //正则匹配
    //var namePattern = /^[a-zA-Z0-9_-]{4,16}$/;
    //校验用户名，校验要求用户名字符长度6~18个字符，首字符必须为英文字母，其它字符范围为数字或英文字母或下划线
    var namePattern = /^[a-zA-Z]\w{5,17}$/;
    if(!(namePattern.test(userName))){
        alert("用户名字符长度6~18个字符，首字符必须为英文字母，其它字符范围为数字或英文字母或下划线");
        return false;
    }
    //校验手机号
    var phonePattern = /^1[3456789]\d{9}$/;
    if(!(phonePattern.test(phone))){
        alert("手机号码有误，请重填");
        return false;
    }
    //校验真实姓名
    var trueNamePattern = /^([\u4e00-\u9fa5]{1,20}|[a-zA-Z\.\s]{1,20})$/;
    if(!(trueNamePattern.test(trueName))){
        alert("输真名啊");
        return false;
    }
    //校验邮箱
    var emailPattern = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
    if(!(emailPattern.test(email))){
        alert("邮箱有误,请重填");
        return false;
    }
    //检验密码强弱
    var easyPasswordPattern = /^[\w_-]{6,16}$/;
    var safePasswordPattern = /^.*(?=.{6,16})(?=.*\d)(?=.*[A-Z]{2,})(?=.*[a-z]{2,})(?=.*[!@#$%^&*?\(\)]).*$/;
    if (safePasswordPattern.test(password))
        $("#pwindicator").show();

    // 检验重复密码
    if (password!=repeatassword){
        alert("两次输入的密码不一致");
        return false;
    }

    var codeName= ["弱","中","强","超强"];
    function checkStrong(val) {
                var modes = 0;
                if (val.length < 6) return 0;
                if (/\d/.test(val)) modes++; //数字
                if (/[a-z]/.test(val)) modes++; //小写
                if (/[A-Z]/.test(val)) modes++; //大写
                if (/\W/.test(val)) modes++; //特殊字符
                if (val.length > 12) return 4;
                return modes;
            }




    //表单序列化
    var jsonData = $('#register-form').serialize();
    if (jsonData.password) {
        jsonData.password = $.md5(jsonData.password);
    }
    delete jsonData["confirmPassword"];
    $.ajax('/register/saveUser', {
        dataType: 'json',
        type: 'POST',
        data: jsonData,
        success: function (data) {
            isSubmit = 0;
            if (data.code == 200) {
                window.location.href = "index.html";
            } else {
                alert("注册失败");
            }
        },
        error: function (_error) {
            alert("注册失败");
        }
    });
    return false;

});