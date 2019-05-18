$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/user/list',
        datatype: "json",
        colModel: [			
			{ label: '用户ID', name: 'id', index: "id", width: 45, key: true },
			{ label: '登录账号', name: 'loginName', width: 75 },
            { label: '用户名', name: 'name', sortable: false, width: 75 },
            { label: '性别', name: 'sex', sortable: false, width: 45,formatter : function(sex,index) {
				if (sex === 1) {
					return '<span>男</span>';
				}
				if (sex === 0) {
					return '<span>女</span>';
				}
			}},
            { label: '年龄', name: 'age', sortable: false, width: 45},
            { label: '用户类型', name: 'userType', sortable: false, width: 45 },
            { label: '代理分层', name: 'type', sortable: false, width: 45,formatter : function(type,index) {
				if (type === 0) {
					return '<span>平台商</span>';
				}
				if (type === 1) {
					return '<span>总代理</span>';
				}
				if (type === 2) {
					return '<span>二级代理</span>';
				}
			}},
			{ label: '所属平台', name: 'cid', index: "cid",width: 90 },
			{ label: '状态', name: 'status', width: 60, formatter: function(value, options, row){
				return value != 0 ? 
					'<span class="label label-danger">禁用</span>' : 
					'<span class="label label-success">正常</span>';
			}},
			{ label: '创建时间', name: 'createTime', index: "create_time", width: 85}
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

//角色组件
var role_ztree;
var role_setting={
	data: {
	    simpleData: {
	        enable: true,
	        idKey: "id",
	        rootPId:0
	    },
		key: {
		    url:"nourl"
		    }
	},
	check : {
		enable : true,
		nocheckInherit : true,
		chkStyle: "radio",  //单选框
        radioType: "all"   //对所有节点设置单选
	}
};

//平台商组件
var cagent_ztree;
var cagent_setting={
	data: {
	    simpleData: {
	        enable: true,
	        idKey: "id",
	        rootPId:0
	    },
		key: {
		    url:"nourl"
		    }
	},
	check : {
		enable : true,
		nocheckInherit : true,
		chkStyle: "radio",  //单选框
        radioType: "all"   //对所有节点设置单选
	}
};

var vm = new Vue({
    el:'#txapp',
    data:{
        q:{
            name: null
        },
        showList: true,
        title:null,
        user:{
            id:null,
            loginName:null,
            name:null,
            password:null,
            sex:0,
            age:20,
            phone:null,
            userType:0,
            status:0,
            cid:null,
            cagent:null,
            type:0,
            roleId:null,
            roleName:null,
        }
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.getCagentList();
            vm.getRoleList();
        },
        update: function () {
            var userId = getSelectedRow();
            if(userId == null){
                return ;
            }
            vm.showList = false;
            vm.title = "修改";
            vm.getUser(userId);
            vm.getCagentList();
            vm.getRoleList();
        },
        permissions: function () {
            var userId = getSelectedRow();
            if(userId == null){
                return ;
            }

            window.location.href=baseURL+"sys/permissions/index/"+userId;
        },
        del: function () {
            var userIds = getSelectedRows();
            if(userIds == null){
                return ;
            }
            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/user/delete",
                    contentType: "application/json",
                    data: JSON.stringify(userIds),
                    success: function(r){
                        if(r.code == 0){
                            alert('操作成功', function(){
                                vm.reload();
                            });
                        }else{
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        saveOrUpdate: function () {
            var url = vm.user.userId == null ? "sys/user/add" : "sys/user/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.user),
                success: function(r){
                    if(r.status === 0){
                        alert('操作成功', function(){
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
        getUser: function(userId){
            $.get(baseURL + "sys/user/info/"+userId, function(r){
                if(r.status == 0){
                	//获取已勾选的角色和菜单
                	vm.user = r.data;
                	//已勾选的角色
                	role_ztree = $.fn.zTree.getZTreeObj("roleTree");
                	var roleNode = role_ztree.getNodeByParam("id",vm.user.roleId);
                	role_ztree.checkNode(roleNode, true, true);
                	//已勾选的平台
                	cagent_ztree = $.fn.zTree.getZTreeObj("cagentTree");
                	var cagentNode = cagent_ztree.getNodeByParam("id",vm.user.cid);
                	cagent_ztree.checkNode(cagentNode, true, true);
                }
            });
        },
        
        getCagentList: function(){
            //加载平台树
            $.get(baseURL + "cagent/select", function(r){
                cagent_ztree = $.fn.zTree.init($("#cagentTree"), cagent_setting, r);
                var node = cagent_ztree.getNodeByParam("cid", vm.user.cid);
                if(node != null){
                	cagent_ztree.selectNode(node);
                	vm.user.cid = node.id;
                }
            })
        },
        
        getRoleList: function(){
        	//加载角色树
            $.get(baseURL + "sys/role/select", function(r){
            	role_ztree = $.fn.zTree.init($("#roleTree"), role_setting, r);
                var node = role_ztree.getNodeByParam("roleId", vm.user.roleId);
                if(node != null){
                	role_ztree.selectNode(node);
                	vm.user.roleId = node.id;
                }
            });
        },
        
        cagentTree: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择平台商",
                area: ['800px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#cagentLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = cagent_ztree.getSelectedNodes();
                    vm.user.cid = node[0].id;
                    vm.user.cagent = node[0].cagent;
                    layer.close(index);
                }
            });
        },
        
        roleTree: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择角色",
                area: ['800px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#roleLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = role_ztree.getSelectedNodes();
                    vm.user.roleId = node[0].id;
                    vm.user.roleName = node[0].name;
                    layer.close(index);
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