Ext.define('app.controller.MainController',{
	extend:'Ext.app.Controller',
	
	views:['main.MenuTree','main.region.Top','main.region.Bottom'],
	stores:['menuStore'],
	models:['userManage.UserModel','userManage.RoleModel'],
	
	init:function(app){
		this.control({
			'#menuTree':{
				//左边菜单单击事件
				itemclick:function(tree,record,item,index,e,options){
					//获取页面上id为tabPanel的组件
					var tabs = Ext.getCmp('tabPanel');
					//获取点击的菜单树的节点信息
					var treeNode=record.raw;
					//
					if(treeNode.leaf){
						var id = treeNode.id;
						var text=treeNode.text;
						var controller = treeNode.contr;
						var view = treeNode.view;
						var tab = tabs.getComponent(id); 
						if(!tab){
							app.getController(controller);
							var mainPanel = Ext.widget(view,{
								id:id,
								closable: true,
								title:text,
								closeAction:'destory',
								autoDestory:true,
							});
							//mainPanel.getStore().load();
							tabs.add(mainPanel);
							tabs.setActiveTab(mainPanel);
							
						}else{
							tabs.setActiveTab(tab);
						}
					}
				}
			}
		});
	},
	
	

});