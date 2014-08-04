//全局变量
var GIRD;

//--------------------------自定义的方法---------------------------
var doSaveOrUpdata = function(user){
	Ext.Ajax.request({
	    url: '/Demo/user/saveOrUpdata',
	    method:"POST",
	    params:{
	    	userName:user.userName,
	    	password:user.password,
	    	realName:user.realName,
	    	uuid:user.uuid
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
	    url: '/Demo/user/delete',
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

Ext.define('app.controller.userManage.UserController',{
	extend:'Ext.app.Controller',
	stores:['userManage.user.UserStore'],
	models:['userManage.UserModel'],
	views:['userManage.user.UserList','userManage.user.AddUserForm'],
	
	
	init:function(){
		this.control({
			//添加人员按钮
			'userList button[id=add]':{
	        	click:function(o){
	        		GIRD = o.ownerCt.ownerCt;
	        		var addForm = Ext.widget('adduserform');
					addForm.show();
	        		
	        	}
			},
			//修改人员按钮
			'userList button[id=updata]':{
	        	click:function(o){
	        		
	        		
	        		GIRD = o.ownerCt.ownerCt;
	        		var data = GIRD.getSelectionModel().getSelection();
					if(data.length == 0){
						Ext.Msg.alert("提示","您要选择一条数据哦");
					}else if(data.length >1){
						Ext.Msg.alert("提示","您只能选择一条数据哦");
					}else{
						var addWin = Ext.widget('adduserform');
						//var record = GIRD.getSelectionModel()
						var addForm = Ext.getCmp('addform');
						var basic = addForm.getForm();
						addWin.title="修改人员";
						Ext.Array.each(data,function(record){
							basic.loadRecord(record);
						});
						
					  	
					  	addWin.show();
					}
	        		
					
	        		
	        	}
			},
			
			//删除人员按钮
			'userList button[id=delete]':{
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
			'adduserform button[name=submit]':{
				click:function(btn){ 
					var form = Ext.getCmp('addform');
					var basic = form.getForm();
					
					var userName = basic.findField("userName").getValue();
					var password = basic.findField("password").getValue();
					var realName = basic.findField("realName").getValue();
					var uuid = basic.findField("uuid").getValue();
					
					var user = {
							userName:userName,
							password:password,
							realName:realName,
							uuid:uuid
					}
					
					//alert(nameValue);
					
					doSaveOrUpdata(user);
					
					var win =form.ownerCt;
					win.close();
				}
			},
			
			//添加人员表单返回
			'adduserform button[name=back]':{
				click:function(btn){
					var win = btn.ownerCt.ownerCt;
					win.close();
				}
			}
		});
	}
});