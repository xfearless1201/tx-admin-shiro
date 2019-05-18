$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'activity/redpacket/list',
        datatype: "json",
        colModel: [
            { label: '平台名称', name: 'uid'},
            { label: '活动名称', name: 'luckyname', width: 45 },
            { label: '已用金额', name: 'amountUsed', sortable: false, width: 45 },
            { label: '抽奖最小金额', name: 'minamount', sortable: false, width: 100 },
            { label: '抽奖最大金额', name: 'maxamount', sortable: false, width: 100 },
            { label: '活动总金额', name: 'amountLimit', sortable: false, width: 100 },
            { label: '每日抽奖开始时间', name: 'beginTime', width: 90 },
            { label: '每日抽奖结束时间', name: 'endTime', width: 90 },
            { label: '金额计算方式', name: 'type', width: 90 },
            { label: '状态', name: 'status', width: 45 },
            { label: '抽奖类型', name: 'typesof', width: 90 },
            { label: '创建人', name: 'adduid', width: 45 },
            { label: '创建时间', name: 'addtime', width: 90 },
            { label: '最后修改人', name: 'updateuid', width: 45 },
            { label: '修改时间', name: 'updatetime', width: 90 }
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