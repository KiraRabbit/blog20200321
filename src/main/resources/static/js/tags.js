var table;
var tests ;










layui.use('table', function(){
    table = layui.table;
    table.render({
        elem: '#test'
        ,sort: false
        ,url:'/tags/getHouseInfo/'
        ,even: true//隔行换色
        ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
            layout: ['prev', 'page', 'next', 'skip', 'count', 'limit'] //自定义分页布局
            ,limit: 20
            ,curr: 1 //设定初始在第 5 页
            //,groups: 1 //只显示 1 个连续页码
            ,first: false //不显示首页
            ,last: false //不显示尾页

        },
        jump: function (obj, first) {
            // console.log(obj);
            if (!first) {
                location.href = "/tags/getHouseInfo&page=" + obj.curr;
            }
        }

        ,cols: [[
            {field:'id', width:'5%', title: 'ID'}
            ,{field:'currentData', width:'8%', title: '数据来源日期'}
            ,{field:'location', width:'8%', title: '区域'}
            ,{field:'houseType', width:'8%', title: '面积',
                templet: function(d){
                    return d.houseType+"平方"}
                    }
            ,{field:'village', width:'8%', title: '户型'}
            ,{field:'orientation', width: '8%',title: '装修程度' } //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
            ,{field:'decorate',width: '8%', title: '楼层' }
            ,{field:'perSquare', width: '8%',title: '每平方单价'}
            ,{field:'money', width: '8%',title: '总价',
                templet: function(d){
                    return d.money+"万"}
                    }
            ,{field:'url', title: '地址',
                templet: function(d){
                    return '<a href="' +d.url+ '">' + d.url + '</a>'}
            }
          /*  ,{field:'wealth', width:137, title: '财富', sort: true}*/
        ]]
    });
});

$("#search-house").on("click", function () {
    var location = $("#select-area").val();

    var houseTypeLess = $("#houseTypeLess").val();
    var houseTypeMore = $("#houseTypeMore").val();
    var moneyLess = $("#moneyLess").val();
    var moneyMore = $("#moneyMore").val();
    var obj = {};
    obj.location = location;
    obj.houseTypeLess = houseTypeLess;
    obj.houseTypeMore = houseTypeMore;
    obj.moneyLess = moneyLess;
    obj.moneyMore = moneyMore;
    tests = obj;
    table.reload("test",{
        page:{
            curr: 1 //设定初始在第 5 页
        }
        ,where: obj
    });

});