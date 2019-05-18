var setting = {
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
    }
};
var ztree;

var vm = new Vue({
    el:'#txapp',
    data:{
        showList: true,
        title: null,
        menu:{
        	name:null,
            pid:0,
            pname:null,
            url:null,
            nurl:null,
            perms:null,
            icon:null,
            nicon:null,
            type:0,
            seq:0,
            isSys:0,
            status:0,
        },
    },
    methods: {
        getMenu: function(menuId){
            //加载菜单树
            $.get(baseURL + "sys/menu/select", function(r){
            	if(r.status == 0){
            		ztree = $.fn.zTree.init($("#menuTree"), setting, r.data);
            		var node = ztree.getNodeByParam("id", vm.menu.pid);
            		ztree.selectNode(node);
            		vm.menu.pname = node.name;
            	}else{
            		alert(r.msg);
                }
            })
        },
        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.getMenu();
        },
        update: function () {
            var menuId = getMenuId();
            if(menuId == null){
                return ;
            }

            $.get(baseURL + "sys/menu/info/"+menuId, function(r){
                if(r.status == 0){
                	vm.showList = false;
                	vm.title = "修改";
                	vm.menu = r.data;
                	vm.getMenu();
                }else{
                	alert(r.msg);
                }
            });
        },
        del: function () {
            var menuId = getMenuId();
            if(menuId == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/menu/delete",
                    data: "menuId=" + menuId,
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
            });
        },
        saveOrUpdate: function () {
            if(vm.validator()){
                return ;
            }
            var url = vm.menu.id == null ? "sys/menu/save" : "sys/menu/update";
            $.ajax({
                type: "POST",
                url:  baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.menu),
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
        //禁用或开启
        disableOrEnable:function(item,index){
        	vm.menu.id = getMenuId();
        	vm.menu.status = item.status;
        	var url = "sys/menu/disableOrEnable";
        	$.ajax({
                type: "POST",
                url:  baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.menu),
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
        menuTree: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择菜单",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#menuLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    //选择上级菜单
                    vm.menu.pid = node[0].id;
                    vm.menu.pname = node[0].name;
                    layer.close(index);
                }
            });
        },
        reload: function () {
            vm.showList = true;
            Menu.table.refresh();
        },
        validator: function () {
            if(isBlank(vm.menu.name)){
                alert("菜单名称不能为空");
                return true;
            }
            //菜单
            if(vm.menu.type === 1 && isBlank(vm.menu.nurl)){
                alert("菜单URL不能为空");
                return true;
            }
        }
    }
});


var Menu = {
    id: "menuTable",
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Menu.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: true},
        {title: '菜单ID', field: 'id', visible: false, align: 'center', valign: 'middle', width: '90px'},
        {title: '父菜单ID', field: 'pid',align: 'center', valign: 'middle', visible: false, width: '90px'},
        {title: '菜单名称', field: 'name', align: 'center', valign: 'middle', sortable: true, width: '180px'},
        {title: '上级菜单', field: 'pname', align: 'center', valign: 'middle', sortable: true, width: '100px'},
        {title: '旧图标', field: 'icon', align: 'center', valign: 'middle', sortable: true, width: '80px', formatter: function(item, index){
            return item.icon == null ? '' : '<i class="'+item.icon+' fa-lg"></i>';
        }},
        {title: '新图标', field: 'nicon', align: 'center', valign: 'middle', sortable: true, width: '80px', formatter: function(item, index){
            return item.icon == null ? '' : '<i class="'+item.nicon+' fa-lg"></i>';
        }},
        {title: '旧类型', field: 'resourceType', align: 'center', valign: 'middle', sortable: true, width: '100px', formatter: function(item, index){
            if(item.type === 0){
                return '<span class="label label-primary">目录</span>';
            }
            if(item.type === 1){
                return '<span class="label label-success">菜单</span>';
            }
            if(item.type === 2){
                return '<span class="label label-warning">按钮</span>';
            }
        }},
        {title: '新类型', field: 'type', align: 'center', valign: 'middle', sortable: true, width: '100px', formatter: function(item, index){
            if(item.type === 0){
                return '<span class="label label-primary">目录</span>';
            }
            if(item.type === 1){
                return '<span class="label label-success">菜单</span>';
            }
            if(item.type === 2){
                return '<span class="label label-warning">按钮</span>';
            }
        }},
        {title: '排序号', field: 'seq', align: 'center', valign: 'middle', sortable: true, width: '80px'},
        {title: '菜单URL', field: 'url', align: 'center', valign: 'middle', sortable: true, width: '160px'},
        {title: '新菜单URL', field: 'nurl', align: 'center', valign: 'middle', sortable: true, width: '160px'},
        {title: '菜单状态', field: 'status', align: 'center', valign: 'middle', sortable: true, width: '100px', formatter: function(item, index){
            if(item.status === 0){
                return '<span class="label label-primary">开启</span>';
            }
            if(item.status === 1){
                return '<span class="label label-success">禁用</span>';
            }
        }},
        {title: '创建时间', field: 'createTime', align: 'center', valign: 'middle', sortable: true,width: '160px'},
        {title: '授权标识', field: 'perms', align: 'center', valign: 'middle', sortable: true}]
    return columns;
};


function getMenuId () {
    var selected = $('#menuTable').bootstrapTreeTable('getSelections');
    if (selected.length == 0) {
        alert("请选择一条记录");
        return null;
    } else {
        return selected[0].id;
    }
}


$(function () {
    var colunms = Menu.initColumn();
    var table = new TreeTable(Menu.id, baseURL + "sys/menu/list", colunms);
    table.setExpandColumn(2);
    table.setIdField("id");
    table.setCodeField("id");
    table.setParentCodeField("pid");
    table.setExpandAll(false);
    table.init();
    Menu.table = table;
});
