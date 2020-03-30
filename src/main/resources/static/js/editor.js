var testEditor;
$(function () {
    testEditor = editormd("test-editormd", {
        width: "85%",
        height: 800,
        syncScrolling: "single",
        path: "editMd/lib/", //依赖lib文件夹路径
        emoji: true,
        taskList: true,
        tocm: true,
        imageUpload: true,
        imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
        imageUploadURL: "imageUpload"		//上传图片控制器Mapping
    });
});


$("#save").on('click', function () {
    var title = $('#title').val();
    var content = $('#content').val();
    //author
    var author = "kira";
    $.ajax('/editor/insertContent', {
        dataType: 'json',
        type: 'POST',
        data: {"articleName": title,
            "content": content,
            "author": author},
        success: function (data) {
            alert("保存成功")
        },
        error: function (_error) {
            alert("保存失败")
        }
    });


});