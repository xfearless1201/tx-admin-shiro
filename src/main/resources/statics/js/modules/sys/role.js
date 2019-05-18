$(function() {
	$("#jqGrid").jqGrid({
		url : baseURL + 'sys/role/list',
		datatype : "json",
		colModel : [ {
			label : '角色ID',
			name : 'id',
			index : "id",
			width : 45,
			key : true
		}, {
			label : '角色名称',
			name : 'name',
			index : "name",
			width : 75
		}, {
			label : '角色描述',
			name : 'description',
			width : 100
		}, {
			label : '角色状态',
			name : 'status',
			index : "status",
			width : 80,
			formatter : function(status) {
				if (status === 0) {
					return '<span class="label label-primary">开启</span>';
				}
				if (status === 1) {
					return '<span class="label label-success">禁用</span>';
				}
			}
		} ],
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

//菜单树
var menu_setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pid",
            rootPId: -1
        },
        key: {
            url:"nourl"
        }
    },
    check : {
		enable : true,
		nocheckInherit : true
	}
};
var ztree;
var vm = new Vue({
	el : '#txapp',
	data : {
		q : {
			roleName : null
		},
		showList : true,
		title : null,
		role : {
			id : null,
			name : null,
			seq : 0,
			description : null,
			status : 0,
			cid : 0,
			menuIdList : null
		}
	},
	methods : {
		query : function() {
			vm.reload();
		},
		add : function() {
			vm.showList = false;
			vm.title = "新增";
			vm.getMenuTree(null);
		},
		update : function() {
			var roleId = getSelectedRow();
			if (roleId == null) {
				return;
			}
			vm.showList = false;
			vm.title = "修改";
			vm.getMenuTree(roleId);
		},
		del : function() {
			var roleIds = getSelectedRows();
			if (roleIds == null) {
				return;
			}

			confirm('确定要删除选中的记录？', function() {
				$.ajax({
					type : "POST",
					url : baseURL + "sys/role/delete",
					contentType : "application/json",
					data : JSON.stringify(roleIds),
					success : function(r) {
						if (r.code == 0) {
							alert('操作成功', function() {
								vm.reload();
							});
						} else {
							alert(r.msg);
						}
					}
				});
			});
		},
		getRole : function(roleId) {
			$.get(baseURL + "sys/role/info/" + roleId, function(r) {
				vm.role = r.data;
				//勾选角色所拥有的菜单
				ztree = $.fn.zTree.getZTreeObj("menuTree");
				var menuIds = vm.role.menuIdList;
				for (var i = 0; i < menuIds.length; i++) {
					var node = ztree.getNodeByParam(menuIds[i]);
					ztree.checkNode(node, true, true);
				}
			});
		},
		
		saveOrUpdate : function() {
			//获取选择的菜单
			var nodes = ztree.getCheckedNodes(true);
			var menuIdList = new Array();
			for (var i = 0; i < nodes.length; i++) {
				menuIdList.push(nodes[i].id);
			}
			vm.role.menuIdList = menuIdList;
			var url = vm.role.roleId == null ? "sys/role/add" : "sys/role/update";
			$.ajax({
				type : "POST",
				url : baseURL + url,
				contentType : "application/json",
				data : JSON.stringify(vm.role),
				success : function(r) {
					if (r.status === 0) {
						alert('操作成功', function() {
							vm.reload();
						});
					} else {
						alert(r.msg);
					}
				}
			});
		},
		getMenuTree : function(roleId) {
			//加载菜单树
			$.get(baseURL + "sys/menu/list", function(r) {
				ztree = $.fn.zTree.init($("#menuTree"), menu_setting, r);
				//展开所有节点
				ztree.expandAll(true);
				if (roleId != null) {
					vm.getRole(roleId);
				}
			});
		},
		
		menuTree: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择授权资源",
                area: ['960px', '500px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#menuLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                	var nodes = ztree.getSelectedNodes();
                    //选择上级部门
                	for (var i = 0; i < nodes.length; i++) {
        				vm.role.menuIdList.push(nodes[i].id);
        			}
                    layer.close(index);
                }
            });
        },
		reload : function() {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam', 'page');
			$("#jqGrid").jqGrid('setGridParam', {
				postData : {
					'roleName' : vm.q.roleName
				},
				page : page
			}).trigger("reloadGrid");
		}
	}
});