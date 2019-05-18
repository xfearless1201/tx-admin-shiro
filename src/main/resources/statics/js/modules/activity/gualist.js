+$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'activity/guagua/list',
        datatype: "json",
        colModel: [
            { label: '平台编码', name: 'cagent'},
            { label: '活动名称', name: 'name', width: 45 },
            { label: '已用金额', name: 'userMoney', sortable: false, width: 45 },
            { label: '刮奖最小金额', name: 'minquota', sortable: false, width: 70 },
            { label: '刮奖最大金额', name: 'maxquota', sortable: false, width: 70 },
            { label: '状态', name: 'status', sortable: false, width: 70 },
            { label: '刮奖类型', name: 'type', width: 90 },
            { label: '活动描述', name: 'description', width: 90 },
            { label: '创建人', name: 'createName', width: 90 },
            { label: '创建时间', name: 'createTime', width: 90 },
            { label: '最后修改人', name: 'updateName', width: 45 },
            { label: '修改时间', name: 'updateTime', width: 90 }
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