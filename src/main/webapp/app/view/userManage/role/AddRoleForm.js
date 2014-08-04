Ext.define('ap.view.userManage.user.AddRoleForm', {
	extend : "Ext.window.Window",
	title : "add role form",
	alias : "widget.addroleform",
	xtype : 'contact-form',

	title : '添加用户',
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
		id:"addroleform",
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
			name:'roleName',
			id : "roleName",
			//vtype : 'email',//表单验证
			allowBlank : false //是否可以为空
		},{
			xtype : 'textfield',
			fieldLabel : '说明',
			name:'note',
			id : "note",
			allowBlank : false
		},],
		
	}],
	buttons : [ {
		text : '提交',
		name : 'submit',
		
	}, {
		text : '取消',
		name : 'back'
	} ]
	
});