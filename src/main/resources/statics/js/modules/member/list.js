$(function() {
	$("#memberGrid").jqGrid(
			{
				url : baseURL + 'member/user/list',
				datatype : "json",
				colModel : [
						{
							label : 'uid',
							name : 'uid',
							index : "uid",
							key : true,
							hidden : true
						},
						{
							label : '会员账号',
							name : 'username',
							index : "username",
							width : 40
						},
						{
							label : '用户名',
							name : 'realname',
							index : "realname",
							width : 40
						},
						{
							label : '钱包金额',
							name : 'wallet',
							width : 40
						},
						{
							label : '积分',
							name : 'integral',
							width : 40
						},
						{
							label : '状态',
							name : 'isStop',
							index : "isStop",
							width : 40,
							formatter : function(isStop) {
								
								if (isStop === 1) {
									return '<span class="label label-danger">停用</span>';
								} else {
									return '<span class="label label-success">启用</span>';
								}

							}
						},
						{
							label : '打码量<br/>输赢额',
							name : 'userQuantity',
							width : 90,
							formatter : function(userQuantity, index, row) {
								var str = '';
								if (row.userQuantity > 0) {
									str += '<font color="green">'
											+ row.userQuantity.toFixed(2)
											+ '</font>';
								} else if (row.userQuantity < 0) {
									str += '<font color="red">'
											+ row.userQuantity.toFixed(2)
											+ '</font>';
								} else {
									str += row.userQuantity;
								}
								str += '<br/>';
								if (row.userWinAmount > 0) {
									str += '<font color="green">'
											+ row.userWinAmount.toFixed(2)
											+ '</font>';
								} else if (row.userWinAmount < 0) {
									str += '<font color="red">'
											+ row.userWinAmount.toFixed(2)
											+ '</font>';
								} else {
									str += row.userWinAmount;
								}
								return str;
							}

						},
						{
							label : '代理商<br/>层级',
							name : 'topUidName',
							width : 90,
							height : '40px',
							formatter : function(value, index, row) {
								var str = '';
								if (value == '' || value == null
										|| value == undefined) {
									str = '平台会员';
								} else {
									str = value;
								}
								str += '<br/>';
								str += row.typeName;
								return str;
							}

						},{
							label : '注册日期</br>注册IP',
							name : 'regDate',
							width : 90,
							height : 40,
							formatter:function(value,index,row){
			    				var str=value; 
			    				str+='<br/>';
			    				str+=numberToIp(row.regIp);
			    				return str;
			    			}
						},{
							label : '注册方式</br>注册来源',
							name : 'isMobile',
							width : 90,
							height : 40,
							formatter: function(value,index,row){
			    				var mobile = "";
			       				if(value==0||value==null){
			       					mobile = "PC";
			       				}else if(value==1){
			       					mobile = "手机";
			       				}else if(value==2){
			       					mobile = "APP";
			       				}else if(value==3){
			       					mobile = "IOS";
			       				}else if(value==4){
			       					mobile = "Android";
			       				}else if(value == 99){
			       					mobile = "手工注册";
			       				}
			       				return mobile + "</br>"+row.regurl;
			    			}
						},{
							label : '常用操作',
							name : 'c1',
							width : 90,
							height : 40,
							formatter : function(value,index,row){
								 var str = '';
		                            str += $.formatString("<button type='button' onclick=codeamount(\'{0}\') class='btn btn-info'>打码量</button>", row.uid);
		                            return str;
			                }
						},
						
					],
				viewrecords : true,
				height : 578,
				rowNum : 25,
				rowList : [ 25, 50, 100 ],
				rownumbers : true,
				rownumWidth : 25,
				autowidth : true,
				multiselect : true,
				pager : "#memberGridPager",
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
					// 隐藏grid底部滚动条
					$("#memberGrid").closest(".ui-jqgrid-bdiv").css({
						"overflow-x" : "hidden"
					});
				}
			});
});

function codeamount(uid){
	
}

function numberToIp(number) { 
	if(number=="null"||number==null){
		return number;
	}
	if(number.indexOf(".")>0){
		return number;
	}
    var ip = "";  
    if(number <= 0) {  
        return ip;  
    }  
    var ip3 = (number << 0 ) >>> 24;  
    var ip2 = (number << 8 ) >>> 24;  
    var ip1 = (number << 16) >>> 24;  
    var ip0 = (number << 24) >>> 24  
      
    ip += ip3 + "." + ip2 + "." + ip1 + "." + ip0;  
      
    return ip;     
}

var vm = new Vue({
	el : '#txapp',
	data : {
		q : {
			name : null
		},
		showList : true,
		title : null,
		role : {
			menuId : null,
			menuName : null
		}
	},
	methods : {
		query : function() {
			vm.reload();
		},
		add : function() {
			vm.showList = false;
			vm.title = "新增";
			vm.role = {
				deptName : null,
				deptId : null
			};
			vm.getMenuTree(null);
		},
		update : function() {
			var roleId = 500;// getSelectedRow();
			if (roleId == null) {
				return;
			}
			vm.showList = false;
			vm.title = "修改";
			vm.getMenuTree(500);
		},
		saveOrUpdate : function() {
			// 获取选择的菜单
			var nodes = menu_ztree.getCheckedNodes(true);
			var menuIdList = new Array();
			for (var i = 0; i < nodes.length; i++) {
				menuIdList.push(nodes[i].menuId);
			}
			vm.role.menuIdList = menuIdList;

			// 获取选择的数据
			var nodes = data_ztree.getCheckedNodes(true);
			var deptIdList = new Array();
			for (var i = 0; i < nodes.length; i++) {
				deptIdList.push(nodes[i].deptId);
			}
			vm.role.deptIdList = deptIdList;

			var url = vm.role.roleId == null ? "sys/role/save"
					: "sys/role/update";
			$.ajax({
				type : "POST",
				url : baseURL + url,
				contentType : "application/json",
				data : JSON.stringify(vm.role),
				success : function(r) {
					if (r.code === 0) {
						alert('操作成功', function() {
							vm.reload();
						});
					} else {
						alert(r.msg);
					}
				}
			});
		},
		reload : function() {
			vm.showList = true;
			var page = $("#memberGrid").jqGrid('getGridParam', 'page');
			$("#memberGrid").jqGrid('setGridParam', {
				postData : {
					'name' : vm.q.name
				},
				page : page
			}).trigger("reloadGrid");
		}
	}
});