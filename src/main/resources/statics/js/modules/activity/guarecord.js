$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'activity/guagua/record',
        datatype: "json",
        colModel: [
            { label: '会员账号', name: 'username'},
            { label: '用户名', name: 'realname', width: 45 },
            { label: '活动名称', name: 'activity_name', sortable: false, width: 45 },
            { label: '刮奖金额', name: 'activity_amount', sortable: false, width: 70 },
            { label: '刮奖时间', name: 'carete_time', sortable: false, width: 70 },
            { label: '活动状态', name: 'flag', sortable: false, width: 70 },
            { label: '活动编号', name: 'activity_number', width: 90 },
            { label: '审核时间', name: 'verify_time', width: 90 },
            { label: '审核人', name: 'verifier', width: 90 },
            { label: '备注', name: 'rmk', width: 45 },
            { label: '审核操作', name: 'endTime', width: 90 }
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