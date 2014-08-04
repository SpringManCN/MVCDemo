Ext.define('app.view.userManage.depart.DepartView',{
	extend: 'Ext.tree.Panel',
	alias:'widget.departView',
	id:"departView",
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
    	text: '描述', 
    	dataIndex: 'note' ,
    	flex: 1
    }],  
    
    store:'userManage.DepartStore',
    
    tbar : [{
		xtype : 'button',
		text : '添加部门',
		id : 'addDepart'
	},
	{
		xtype : 'button',
		text : '修改部门',
		id : 'updateDepart',
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
				win.title="修改部门";
				Ext.Array.each(data,function(record){
					basic.loadRecord(record);
				});
			  	win.show();
			}
    		
    	}*/
	},
	{
		xtype : 'button',
		text : '删除部门',
		id : 'deleteDepart',
	}
	
],
}); 