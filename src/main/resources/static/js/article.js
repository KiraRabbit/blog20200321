var test;

$(function () {
    var id = getUrlParam("id");

    $.ajax('/article/getContent', {
        dataType: 'json',
        type: 'GET',
        data: {
            id: id
        },

        success: function (data) {
            //$("#acticle-content").innerHTML(data.result.content);
            $("#articleName").html(data.result.articleName);
            //先对容器初始化，在需要展示的容器中创建textarea隐藏标签，
            $("#test-editormd").html('<textarea id="mdContent" style="display:none;"></textarea>');
            var content = data.result.content;//获取需要转换的内容
            $("#mdContent").val(content);//将需要转换的内容加到转换后展示容器的textarea隐藏标签中

            editormd.markdownToHTML("test-editormd", {
                htmlDecode: "style,script,iframe",
                emoji: true,
                taskList: true,
                tex: true,  // 默认不解析
                flowChart: true,  // 默认不解析
                sequenceDiagram: true  // 默认不解析
            });

        },
        error: function (data) {
            alert("失败")
        }
    });


});

// $("#mobile-nav-taggle").click(function () {
//     var mobileMenu = $("#mobile-menu");
//     if (mobileMenu.hasClass("show-nav")) {
//         setTimeout(function () {
//             mobileMenu.addClass("hide-nav").removeClass("show-nav");
//         }, 100)
//     }
//     else {
//         setTimeout(function (){
//             mobileMenu.addClass("show-nav").removeClass("hide-nav");
//         }, 100)
//     }
// })

$("#toggle").click(function() {
    $(".menu").toggleClass("closed");
    $(this).toggleClass("closed");
    $(".content").toggleClass("closed");
    $("#wrapper").toggleClass("closed")
});

function getUrlParam(name) {
    var url = window.location.href;
    if (url != null && url.indexOf("?") != -1) {
        var url_param = url.split("?")[1];
        var url_param_arr = url_param.split("&");
        for (var i = 0; i < url_param_arr.length; i++) {
            var tempParam = url_param_arr[i];
            var paramName = tempParam.split("=")[0];
            if (paramName == name) {
                return tempParam.split("=")[1]
            }
        }
    }
    return 1;
}