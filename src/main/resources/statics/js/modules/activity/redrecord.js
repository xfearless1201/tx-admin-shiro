$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'activity/redpacket/record',
        datatype: "json",
        colModel: [
            { label: '会员账号', name: 'uid'},
            { label: '用户名', name: 'uid', width: 45 },
            { label: '活动名称', name: 'lid', sortable: false, width: 45 },
            { label: '中奖金额', name: 'amount', sortable: false, width: 100 },
            { label: '抽奖时间', name: 'addtime', sortable: false, width: 100 },
            { label: '当日抽奖次数', name: 'todaytimes', sortable: false, width: 100 },
            { label: '总抽奖次数', name: 'totaltimes', width: 90 },
        ],
        viewrecords: true,
        height: 578,
        rowNum: 15,
        rowList : [15,30,50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "data.list",
            page: "data.page",
            total: "data.totalPage",
            records: "data.totalCount"
        },
        prmNames : {
            page:"page",
            rows:"limit",
            order: "order"
        },
        gridComplete:function(){
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        }
    });
});
var vm = new Vue({
    el:'#txapp',
    data:{
        q:{
            name: null
        },
        showList: true,
        title:null,
        cagent:{}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        reload: function () {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'name': vm.q.name},
                page:page
            }).trigger("reloadGrid");
        }
    }
});