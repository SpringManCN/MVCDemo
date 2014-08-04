//全局变量
var GIRD;

//--------------------------自定义的方法---------------------------
var doSaveOrUpdata = function(role){
	Ext.Ajax.request({
	    url: '/Demo/role/saveOrUpdata',
	    method:"POST",
	    params:{
	    	uuid:role.uuid,
	    	roleName:role.roleName,
	    	note:role.note
	    },  
	    success: function(response, opts) {
	        //var obj = Ext.decode(response.responseText);
	    	GIRD.getStore().reload();
	        //console.dir(obj);
	    },
	    failure: function(response, opts) {
	        console.log('server-side failure with status code ' + response.status);
	    }
	});
};

var doDelete = function(uuids){
	Ext.Ajax.request({
	    url: '/Demo/role/delete',
	    method:"POST",
	    params:{
	    	uuids:uuids
	    },  
	    success: function(response, opts) {
	        //var obj = Ext.decode(response.responseText);
	    	GIRD.getStore().reload();
	        //console.dir(obj);
	    },
	    failure: function(response, opts) {
	        console.log('server-side failure with status code ' + response.status);
	    }
	});
};

//--------------------------自定义的方法---------------------------

Ext.define('app.controller.userManage.RoleController',{
	extend:'Ext.app.Controller',
	stores:['userManage.role.RoleStore'],
	models:['userManage.RoleModel'],
	views:['userManage.role.RoleList','userManage.role.AddRoleForm'],
	
	init:function(){
		this.control({
			//添加人员按钮
			'roleList button[id=addRole]':{
	        	click:function(o){
	        		GIRD = o.ownerCt.ownerCt;
	        		var addroleForm = Ext.widget('addroleform');
	        		addroleForm.show();
	        		
	        	}
			},
			//修改人员按钮
			'roleList button[id=updateRole]':{
	        	click:function(o){
	        		GIRD = o.ownerCt.ownerCt;
	        		var data = GIRD.getSelectionModel().getSelection();
					if(data.length == 0){
						Ext.Msg.alert("提示","您要选择一条数据哦");
					}else if(data.length >1){
						Ext.Msg.alert("提示","您只能选择一条数据哦");
					}else{
						var addWin = Ext.widget('addroleform');
						var addForm = Ext.getCmp('addroleform');
						var basic = addForm.getForm();
						addWin.title="修改角色";
						Ext.Array.each(data,function(record){
							basic.loadRecord(record);
						});
					  	addWin.show();
					}
	        		
	        	}
			},
			
			//删除人员按钮
			'roleList button[id=deleteRole]':{
				click:function(o){
					GIRD = o.ownerCt.ownerCt;
					var data = GIRD.getSelectionModel().getSelection();
					if(data.length == 0){
						Ext.Msg.alert("提示","您最少要选择一条数据");
					}else{
						var st = GIRD.getStore();
						var uuids =[];
						Ext.Array.each(data,function(record){
								uuids.push(record.data.uuid);
						});
						doDelete(uuids);
					}
				}
			},
			
			//添加人员表单提交
			'addroleform button[name=submit]':{
				click:function(btn){ 
					var form = Ext.getCmp('addroleform');
					var basic = form.getForm();
					
					var uuid = basic.findField("uuid").getValue();
					var roleName = basic.findField("roleName").getValue();
					var note = basic.findField("note").getValue();
					
					
					var role = {
							uuid:uuid,
							roleName:roleName,
							note:note
					}
					
					
					doSaveOrUpdata(role);
					
					var win =form.ownerCt;
					win.close();
				}
			},
			
			//添加人员表单返回
			'addroleform button[name=back]':{
				click:function(btn){
					var win = btn.ownerCt.ownerCt;
					win.close();
				}
			}
		});
	}
});