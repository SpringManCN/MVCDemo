//全局变量
var GIRD;

//--------------------------自定义的方法---------------------------
var doSaveOrUpdata = function(depart){
	Ext.Ajax.request({
	    url: '/Demo/depart/saveOrUpdata',
	    method:"POST",
	    params:{
	    	uuid:depart.uuid,
	    	departName:depart.text,
	    	note:depart.note,
	    	'depart.uuid':depart.pid,
	    },  
	    success: function(response, opts) {
	        //var obj = Ext.decode(response.responseText);
	    	//GIRD.getStore().proxy.extraParams.uuid="";
	    	GIRD.getStore().load();
	        //console.dir(obj);
	    },
	    failure: function(response, opts) {
	        console.log('server-side failure with status code ' + response.status);
	    }
	});
};

var doDelete = function(uuids){
	Ext.Ajax.request({
	    url: '/Demo/depart/delete',
	    method:"POST",
	    params:{
	    	uuids:uuids
	    },  
	    success: function(response, opts) {
	        //var obj = Ext.decode(response.responseText);
	    	GIRD.getStore().load();
	        //console.dir(obj);
	    },
	    failure: function(response, opts) {
	        console.log('server-side failure with status code ' + response.status);
	    }
	});
};

//--------------------------自定义的方法---------------------------

Ext.define('app.controller.userManage.DepartController',{
	extend:'Ext.app.Controller',
	stores:['userManage.DepartStore'],
	//models:['userManage.RoleModel'],
	views:['userManage.depart.DepartView','userManage.depart.DepartForm'],
	
	init:function(){
		this.control({
			//添加人员按钮
			'departView button[id=addDepart]':{
	        	click:function(o){
	        		GIRD = o.ownerCt.ownerCt;
	        		var departform = Ext.widget('departform');
	        		departform.show();
	        		
	        	}
			},
			//修改人员按钮
			'departView button[id=updateDepart]':{
	        	click:function(o){
	        		GIRD = o.ownerCt.ownerCt;
	        		var data = GIRD.getSelectionModel().getSelection();
	    			if(data.length == 0){
	    				Ext.Msg.alert("提示","您要选择一条数据哦");
	    			}else if(data.length >1){
	    				Ext.Msg.alert("提示","您只能选择一条数据哦");
	    			}else{
	    				var win = Ext.widget('departform');
	    				var addForm = Ext.getCmp('adddepartform');
	    				var basic = addForm.getForm();
	    				win.title="修改部门";
	    				Ext.Array.each(data,function(record){
	    					basic.loadRecord(record);
	    				});
	    			  	win.show();
	    			}
	        		
	        	}
			},
			
			//删除人员按钮
			'departView button[id=deleteDepart]':{
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
			'departform button[name=submit]':{
				click:function(btn){ 
					var form = Ext.getCmp('adddepartform');
					var basic = form.getForm();
					
					var uuid = basic.findField("uuid").getValue();
					var pid = Ext.getCmp("pid").value;
					var text = basic.findField("text").getValue();
					var note = basic.findField("note").getValue();
					var depart = {
							uuid:uuid,
							pid:pid,
							text:text,
							note:note
					}
					doSaveOrUpdata(depart);
					var win =form.ownerCt;
					win.close();
				}
			},
			
			//添加人员表单返回
			'departform button[name=back]':{
				click:function(btn){
					var win = btn.ownerCt.ownerCt;
					win.close();
				}
			}
		});
	}
});