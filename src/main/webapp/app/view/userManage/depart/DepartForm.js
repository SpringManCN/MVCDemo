Ext.define('ap.view.userManage.depart.DepartForm', {
	extend : "Ext.window.Window",
	title : "add depart form",
	alias : "widget.departform",
	xtype : 'contact-form',

	uses :["app.ux.ComboboxTree"],
	
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
		id:"adddepartform",
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
			fieldLabel : '说明',
			name:'note',
			id : "note",
			allowBlank : false
		},{
			xtype : 'comboxBoxTree',
			fieldLabel : '上级部门',
			name:'pid',
			id : "pid",
			url: '/Demo/depart/findAll',
			modelStr:'app.model.userManage.DepartModel'
			//store:'userManage.DepartStore'
		}],
		
	}],
	buttons : [ {
		text : '提交',
		name : 'submit',
		/*handler:function(btn){ 
			var form = Ext.getCmp('adddepartform');
			var basic = form.getForm();
			
			var uuid = Ext.getCmp("pid").value;
			var text = basic.findField("text").getValue();
			var note = basic.findField("note").getValue();
			var depart = {
					uuid:uuid,
					text:text,
					note:note
			}
			doSaveOrUpdata(role);
			var win =form.ownerCt;
			win.close();
		}*/
		
	}, {
		text : '取消',
		name : 'back'
	} ]
	
});