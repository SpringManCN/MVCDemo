Ext.define('ap.view.sysm.menu.MenuForm', {
	extend : "Ext.window.Window",
	title : "add depart form",
	alias : "widget.menuwin",
	xtype : 'contact-form',

	uses :["app.ux.ComboboxTree"],
	
	title : '添加菜单',
	frame : true,
	model:true,
	width : 400,
	layout : 'anchor',
	border : false,
	bodyPadding : 10,
	fieldDefaults : {
		labelAlign : 'top',
		labelWidth : 100,
		labelStyle : 'font-weight:bold'
	},
	defaults : {
		anchor : '100%',
		margins : '0 0 10 0'
	},
	items :[{
		id:"menuform",
		xtype:'form',
		border:false,
		items : [ {
			xtype : 'textfield',
			fieldLabel : 'uuid',
			name:'uuid',
			id : "uuid",
			hidden:true,
			allowBlank : false //是否可以为空
		},{
			xtype : 'textfield',
			fieldLabel : '名称',
			name:'text',
			id : "text",
			//vtype : 'email',//表单验证
			allowBlank : false //是否可以为空
		},{
			xtype : 'textfield',
			fieldLabel : '页面视图名称',
			name:'view',
			id : "view",
			allowBlank : false
		},{
			xtype : 'textfield',
			fieldLabel : '页面控制器名称',
			name:'contr',
			id : "contr",
			allowBlank : false
		},{
			xtype : 'comboxBoxTree',
			fieldLabel : '上级菜单',
			name:'pid',
			id : "pid",
			url: '/Demo/menu/findAll',
			modelStr:'app.model.sysm.MenuModel'
			//store:'userManage.DepartStore'
		}],
		
	}],
	buttons : [ {
		text : '提交',
		name : 'submit',
		/*handler:function(btn){ 
			alert(123321);
		}*/
		
	}, {
		text : '取消',
		name : 'back',
		/*handler :function(btn){
			var win = btn.ownerCt.ownerCt;
			win.close();
		}*/
	} ]
	
});