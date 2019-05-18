$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'activity/signin/record',
        datatype: "json",
        colModel: [
            { label: '平台商', name: 'cid',width:45},
            { label: '用户名', name: 'username', width: 45 },
            { label: '用户姓名', name: 'username', sortable: false, width: 45 },
            { label: '最大连续签到天数', name: 'continuousMax', sortable: false, width: 100 },
            { label: '当前连续签到天数', name: 'checkinDays', sortable: false, width: 100 },
            { label: '上次签到日期', name: 'checkinOnDate', sortable: false, width: 100 },
            { label: '最后签到日期', name: 'checkinAtlastDate', width: 90 },
            { label: '是否连续签到', name: 'whether', width: 90 },
            { label: '签到积分', name: 'checkinIntegral', width: 45 },
            { label: '累计签到积分', name: 'checkinGrandTotal', width: 45 }
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