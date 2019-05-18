$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'cagent/list',
        datatype: "json",
        colModel: [			
			{ label: '平台ID', name: 'id', index: "user_id", width: 45, key: true },
			{ label: '平台编码', name: 'code', width: 45 },
            { label: '平台代理号', name: 'cagent', sortable: false, width: 45 },
            { label: '平台名称', name: 'name', sortable: false, width: 100 },
            { label: '平台上线时间', name: 'upLineTime', sortable: false, width: 100 },
            { label: '平台到期时间', name: 'expirationTime', sortable: false, width: 100 },
			{ label: '平台域名', name: 'domain', width: 90 },
			{ label: '平台手机域名', name: 'mobileDomain', width: 90 },
			{ label: '储值额度', name: 'storedvalue', width: 45 },
			{ label: '储值倍率', name: 'storedratio', width: 45 },
			{ label: '平台类型', name: 'type', width: 60, formatter: function(value, options, row){
				return value != 0 ? 
					'<span class="label label-success">总代理</span>' : 
					'<span class="label label-success">二级代理</span>';
			}},
			{ label: '状态', name: 'status', width: 60, formatter: function(value, options, row){
				return value != 0 ? 
					'<span class="label label-danger">停用</span>' : 
					'<span class="label label-success">正常</span>';
			}},
			{ label: '创建时间', name: 'addtime', index: "addtime", width: 85}
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