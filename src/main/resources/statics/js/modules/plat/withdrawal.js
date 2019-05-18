$(function() {
	$("#jqGrid").jqGrid({
		url : baseURL + 'plat/withdrawal/list',
		datatype : "json",
		colModel : [{
			label : '平台商',
			name : 'cagent.cagent',
			width : 100
		},{
			label : '公司入款优惠比例（%）',
			name : 'companyPayProp',
			width : 100
		}, {
			label : '赠送彩金比例（%）',
			name : 'giftBonusProp',
			width : 100
		},{
			label : '赠送彩金上限',
			name : 'giftBonusLimit',
			width : 100
		},{
			label : '打码量',
			name : 'dama',
			width : 100
		},{
			label : '免费取款次数',
			name : 'freeWithdrawTime',
			width : 100
		},{
			label : '取款手续费',
			name : 'withdrawFee',
			width : 100
		},{
			label : '取款行政费',
			name : 'withdrawManageFee',
			width : 100
		},{
			label : '强制提款手续费',
			name : 'compulsoryWithdrawalFee',
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
		withdrawal:{
			companyPayProp:0,
			giftBonusProp:0,
			giftBonusLimit:0,
			dama:0,
			freeWithdrawTime:0,
			withdrawFee:0,
			withdrawManageFee:0,
			compulsoryWithdrawalFee:0,
		}
	},
	methods: {
		getInfo: function (id) {
			$.get(baseURL + "plat/withdrawal/info/"+id, function(r){
                vm.withdrawal = r.data;
            });
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
			var url = vm.withdrawal.id == null ? "plat/withdrawal/save" : "plat/withdrawal/update";
			$.ajax({
				type: "POST",
				url: baseURL + url,
				contentType: "application/json",
				data: JSON.stringify(vm.withdrawal),
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