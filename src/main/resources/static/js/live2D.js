//Live-2D看板娘模型
L2Dwidget.init({
    model: {
        //jsonpath控制显示那个模型，下面这个就是我觉得最可爱的小萝莉模型 //hijiki  //izumi //shizuku //koharu
        jsonPath: "https://unpkg.com/live2d-widget-model-hijiki/assets/hijiki.model.json", //这里改模型，前面后面都要改
        scale: 1,
    },
    display: {
        position: "left", //设置看板娘的上下左右位置
        width: 120,  //宽度
        height: 200, //高度
        hOffset: 300,  //水平偏移
        vOffset: 200  //垂直偏移
    },
    mobile: {
        show: false,  //在移动端不显示
        scale: 0.4    //移动设备上的缩放
    },
    react: {
        opacityDefault: 0.9, //设置透明度
        opacityOnHover: 0.2
    },
});