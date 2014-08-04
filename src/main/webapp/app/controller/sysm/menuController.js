//全局变量
var GIRD;

//--------------------------自定义的方法---------------------------
var doSaveOrUpdata = function(menu){
	Ext.Ajax.request({
	    url: '/Demo/menu/saveOrUpdata',
	    method:"POST",
	    params:{
	    	uuid:menu.uuid,
	    	text:menu.text,
	    	view:menu.view,
	    	contr:menu.contr,
	    	'menu.uuid':menu.pid,
	    },  
	    success: function(response, opts) {
	    	var menuTree = Ext.getCmp("menuTree");
	    	menuTree.getStore().load();
	    	GIRD.getStore().load();
	    },
	    failure: function(response, opts) {
	        console.log('server-side failure with status code ' + response.status);
	    }
	});
};

var doDelete = function(uuids){
	Ext.Ajax.request({
	    url: '/Demo/menu/delete',
	    method:"POST",
	    params:{
	    	uuids:uuids
	    },  
	    success: function(response, opts) {
	    	var menuTree = Ext.getCmp("menuTree");
	    	menuTree.getStore().load();
	    	GIRD.getStore().load();
	    },
	    failure: function(response, opts) {
	        console.log('server-side failure with status code ' + response.status);
	    }
	});
};

//--------------------------自定义的方法---------------------------

Ext.define('app.controller.sysm.menuController',{
	extend:'Ext.app.Controller',
	stores:['sysm.menuStore'],
	//models:['userManage.RoleModel'],
	views:['sysm.menu.MenuView','sysm.menu.MenuForm'],
	
	init:function(){
		this.control({
			//添加人员按钮
			'menuView button[id=addMenu]':{
	        	click:function(o){
	        		GIRD = o.ownerCt.ownerCt;
	        		var menuwin = Ext.widget('menuwin');
	        		menuwin.show();
	        		
	        	}
			},
			//修改人员按钮
			'menuView button[id=updateMenu]':{
	        	click:function(o){
	        		GIRD = o.ownerCt.ownerCt;
	        		var data = GIRD.getSelectionModel().getSelection();
	    			if(data.length == 0){
	    				Ext.Msg.alert("提示","您要选择一条数据哦");
	    			}else if(data.length >1){
	    				Ext.Msg.alert("提示","您只能选择一条数据哦");
	    			}else{
	    				var win = Ext.widget('menuwin');
	    				var menuform = Ext.getCmp('menuform');
	    				var basic = menuform.getForm();
	    				win.title="修改部门";
	    				Ext.Array.each(data,function(record){
	    					basic.loadRecord(record);
	    				});
	    			  	win.show();
	    			}
	        		
	        	}
			},
			
			//删除人员按钮
			'menuView button[id=deleteMenu]':{
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
			'menuwin button[name=submit]':{
				click:function(btn){ 
					var form = Ext.getCmp('menuform');
					var basic = form.getForm();
					
					var uuid = basic.findField("uuid").getValue();
					var pid = Ext.getCmp("pid").value;
					var text = basic.findField("text").getValue();
					var view = basic.findField("view").getValue();
					var contr = basic.findField("contr").getValue();
					var menu = {
							uuid:uuid,
							pid:pid,
							text:text,
							view:view,
							contr:contr
					}
					doSaveOrUpdata(menu);
					var win =form.ownerCt;
					win.close();
				}
			},
			
			//添加人员表单返回 
			'menuwin button[name=back]':{
				click:function(btn){
					var win = btn.ownerCt.ownerCt;
					win.close();
				}
			}
		});
	}
});