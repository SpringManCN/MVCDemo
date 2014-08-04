Ext.define('ap.view.userManage.user.AddUserForm', {
	extend : "Ext.window.Window",
	title : "add user form",
	alias : "widget.adduserform",
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
		id:"addform",
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
			fieldLabel : '用户名',
			name:'userName',
			id : "userName",
			//vtype : 'email',//表单验证
			allowBlank : false //是否可以为空
		}, {
			xtype : 'textfield',
			fieldLabel : '密码',
			name:'password',
			id : "password",
			inputType: 'password',
			allowBlank : false
		}, {
			xtype : 'textfield',
			fieldLabel : '真实名称',
			name:'realName',
			id : "realName",
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