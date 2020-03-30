var editormd;

editormd.markdownToHTML("test-editormd", {
    htmlDecode      : "style,script,iframe",
    emoji           : true,
    taskList        : true,
    tex             : true,  // 默认不解析
    flowChart       : true,  // 默认不解析
    sequenceDiagram : true  // 默认不解析
});