$(function() {
	$("#jqGrid").jqGrid({
		url : baseURL + 'plat/bank/list',
		datatype : "json",
		colModel : [{
			label : '平台商',
			name : 'cagent.cagent',
			width : 100
		},{
			label : '银行卡号',
			name : 'cardno',
			width : 100
		}, {
			label : '银行户名',
			name : 'realname',
			width : 100
		},{
			label : '银行名称',
			name : 'bankname',
			width : 100
		},{
			label : '开户行地址',
			name : 'bankaddress',
			width : 100
		},{
			label : '类型',
			name : 'type',
			width : 100
		},{
			label : '是否启用',
			name : 'status',
			width : 100
		},{
			label : '最小额度',
			name : 'minquota',
			width : 100
		},{
			label : '最大额度',
			name : 'maxquota',
			width : 100
		},{
			label : '更新时间',
			name : 'updatetime',
			width : 100
		},{
			label : '更新人',
			name : 'user.loginName',
			width : 100
		}],
		viewrecords : true,
		height : 578,
		rowNum : 15,
		rowList : [ 15, 30, 50 ],
		rownumbers : true,
		rownumWidth : 25,
		autowidth : true,
		multiselect : true,
		pager : "#jqGridPager",
		jsonReader : {
			root : "data.list",
			page : "data.page",
			total : "data.totalPage",
			records : "data.totalCount"
		},
		prmNames : {
			page : "page",
			rows : "limit",
			order : "order"
		},
		gridComplete : function() {
			//隐藏grid底部滚动条
			$("#jqGrid").closest(".ui-jqgrid-bdiv").css({
				"overflow-x" : "hidden"
			});
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
		bank:{
			cardno:null,
			realname:null,
			bankname:null,
			bankaddress:null,
			type:null,
			status:null,
			minquota:null,
			maxquota:null,
		}
	},
	methods: {
		query: function () {
            vm.reload();
        },
		getInfo: function (id) {
			$.get(baseURL + "plat/bank/info/"+id, function(r){
                vm.bank = r.data;
            });
		},
		add: function(){
            vm.showList = false;
            vm.title = "新增";
        },
		update: function () {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
			vm.title = "修改";
			vm.getInfo(id);
		},
		saveOrUpdate: function () {
			var url = vm.bank.id == null ? "plat/bank/add" : "plat/bank/update";
			$.ajax({
				type: "POST",
				url: baseURL + url,
				contentType: "application/json",
				data: JSON.stringify(vm.bank),
				success: function(data){
					if(data.code=='success'){
						alert('操作成功', function(){
							vm.reload();
						});
					}else{
						alert(data.msg);
					}
				}
			});
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