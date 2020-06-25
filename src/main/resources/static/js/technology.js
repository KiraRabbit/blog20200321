let editormd, test;
let articleLocation = "article?id=";


$(function () {
    $.ajax('/article/getContentInfo', {
        dataType: 'json',
        type: 'GET',
        data: {
            page: 1,
            size: 10
        },

        success: function (data) {
            //循环的div块
            let content = "";
            for (let i = 0; i < data.result.length; i++) {
                let articleName = data.result[i].articleName;
                let id = data.result[i].id;
                let articleContent = data.result[i].content;
                let author = data.result[i].author;
                let classify = data.result[i].classify;
                let createTime = data.result[i].createTime;
                content = content + '<div style=" margin-bottom: 70px;">' +
                    '<div>' +
                    '<a href=' + articleLocation + id + '/>' +
                    '</div>' +
                    '<div>' +
                    '<a class="articleTitle" href=' + articleLocation + id + '>' +
                    articleName +
                    '</a>' +
                    '</div>' +
                    '<div class="postCon">' +
                    '<div class="articleContent">' +
                    articleContent +
                    '<a id="read" href=' + articleLocation + id + '>' +
                    "阅读全文" +
                    '</a>' +
                    '</div>' +
                    '</div>' +
                    '<div class="clear">' +
                    '</div>' +
                    '<div class="aictleFooter">' +
                    dateFormat(createTime) +
                    "author @ " +
                    author +
                    ' <span class="aictleFooter" '
                    + "阅读(次数)" + '>' +
                    '<text/>' +
                    '<span class="aictleFooter">' +
                    "评论(次数)" +
                    '</span>' +
                    '<text/>' +
                    '<span class="aictleFooter">' +
                    "点赞(次数)" +
                    '</span>' +
                    '<text/> ' +
                    '</div> ' +
                    '</div>'
            }


            $("#mainContent").html(content);

        },
        error: function (data) {
            alert("失败")
        }
    });

});


function dateFormat(date) {
    let now = new Date(date);
    let yy = now.getFullYear();      //年
    let mm = now.getMonth() + 1;     //月
    let dd = now.getDate();          //日
    let clock = yy + "-";
    if (mm < 10) clock += "0";
    clock += mm + "-";
    if (dd < 10) clock += "0";
    clock += dd + " ";
    return clock;
}


