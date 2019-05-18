$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'activity/config/list',
        datatype: "json",
        colModel: [
            { label: '平台商', name: 'name'},
            { label: '活动名称', name: 'activityName', width: 45 },
            { label: '活动类型', name: 'activityTypes', sortable: false, width: 45 },
            { label: '活动状态', name: 'activityStatus', sortable: false, width: 70 },
            { label: '参与方式', name: 'participateTheway', sortable: false, width: 70 },
            { label: '所需积分', name: 'participateFrequency', sortable: false, width: 70 },
            { label: '每天参与次数', name: 'participateFrequency', width: 90 },
            { label: '最大参与次数', name: 'frequencyMax', width: 90 },
            { label: '备注', name: 'rmk', width: 90 },
            { label: '开始时间', name: 'startTime', width: 45 },
            { label: '结束时间', name: 'endTime', width: 90 }
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