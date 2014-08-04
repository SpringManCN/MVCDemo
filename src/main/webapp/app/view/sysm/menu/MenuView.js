Ext.define('app.view.sysm.menu.MenuView',{
	extend: 'Ext.tree.Panel',
	alias:'widget.menuView',
	id:"menuView",
    title: 'TreeGrid',  
    selModel : {
		selType : "checkboxmodel"
	},
	 // 是否显示根节点
    rootVisible: false,
	border: false,
	
    columns: [{  
        xtype: 'treecolumn',                  // 把列的类型设置成treecolumn
        text: '名称',  
        dataIndex: 'text',                    
        width: 150,  
        sortable: true  
    }, { 
    	text: '页面视图名称', 
    	dataIndex: 'view' ,
    	flex: 1
    }, { 
    	text: '页面控制器名称', 
    	dataIndex: 'contr' ,
    	flex: 1
    }],  
    
    store:'sysm.menuStore',
    
    tbar : [{
		xtype : 'button',
		text : '添加菜单',
		id : 'addMenu',
		/*handler : function(o){
        		var menuform = Ext.widget('menuform');
        		menuform.show();
		}*/
	},
	{
		xtype : 'button',
		text : '修改菜单',
		id : 'updateMenu',
		/*handler :function(o){
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
				win.title="修改菜单";
				Ext.Array.each(data,function(record){
					basic.loadRecord(record);
				});
			  	win.show();
			}
    		
    	}*/
	},
	{
		xtype : 'button',
		text : '删除菜单',
		id : 'deleteMenu',
	}
	
],
}); 