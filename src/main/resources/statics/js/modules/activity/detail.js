$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'activity/detail/list',
        datatype: "json",
        colModel: [
            { label: '所属平台商', name: 'cagentName'},
            { label: '活动名称', name: 'activityName', width: 45 },
            { label: '会员名', name: 'username', sortable: false, width: 45 },
            { label: '会员级别', name: 'typename', sortable: false, width: 70 },
            { label: '最后抽奖时间', name: 'lotteryTime', sortable: false, width: 70 },
            { label: '累计抽奖次数', name: 'totalCount', sortable: false, width: 70 },
            { label: '累计所用积分', name: 'totalIntegral', width: 90 },
            { label: '是否中奖', name: 'isWinning', width: 90 },
            { label: '中奖奖品', name: 'prizeName', width: 90 },
            { label: '中奖数量', name: 'amount', width: 45 },
            { label: '累计中奖彩金', name: 'totalWinnings', width: 90 },
            { label: '发放方式', name: 'prizeType', width: 90 },
            { label: '中奖时间', name: 'winningTime', width: 90 }
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