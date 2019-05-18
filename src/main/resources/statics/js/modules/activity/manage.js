$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'activity/redpacket/list',
        datatype: "json",
        colModel: [
            { label: '所属平台商', name: 'cagentName'},
            { label: '活动名称', name: 'activityName', width: 45 },
            { label: '奖品名称', name: 'prizeName', sortable: false, width: 45 },
            { label: '奖品分级', name: 'prizeLevel', sortable: false, width: 100 },
            { label: '奖品类别', name: 'prizeType', sortable: false, width: 100 },
            { label: '奖品数量', name: 'amount', sortable: false, width: 100 },
            { label: '剩余数量', name: 'surplus', width: 90 },
            { label: '奖品状态', name: 'status', width: 90 },
            { label: '上架时间', name: 'putawayTime', width: 90 },
            { label: '下架时间', name: 'unshelveTime', width: 45 },
            { label: '图片路径', name: 'src', width: 90 },
            { label: '备注', name: 'rmk', width: 45 }
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