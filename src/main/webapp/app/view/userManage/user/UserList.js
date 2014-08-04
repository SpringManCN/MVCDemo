
Ext.define('app.view.userManage.user.UserList',{
	extend: 'Ext.grid.Panel',
	alias:'widget.userList',
	id:'userList',
	glyph:0xf016,
	selModel : {
		selType : "checkboxmodel"
	},
	multiSelect : true,
	columns:[
			{ text: 'ID', dataIndex: 'uuid', flex: 1 ,"hidden":true },
			{ text: '姓名', dataIndex: 'realName', flex: 1  },
			{ text: '角色', dataIndex: 'roleName' ,flex: 1},
			{ text: '部门', dataIndex: 'departName' ,flex: 1}
	],
	store:'userManage.user.UserStore',
	dockedItems: [{
        xtype: 'pagingtoolbar',
        store: 'userManage.user.UserStore',
        dock: 'bottom',
        displayInfo: true
    }],
	tbar : [{
				xtype : 'button',
				text : '添加人员',
				id : 'add',
				glyph : 0xf016,
			},
			{
				xtype : 'button',
				text : '修改人员',
				id : 'updata',
			},
			{
				xtype : 'button',
				text : '删除人员',
				id : 'delete',
			},
			
			"->",
			{
				fieldLabel : "关键字",
				labelWidth : 50,
				width : 150,
				xtype : 'textfield',
				name : "searchmatter",
				id : "adminsearchmatter",
				emptyText : "请输入关键字",
				selectOnFocus : true
			},
			{
				xtype : "button",
				id : "search",
				iconCls : "search",
				text : "搜索"
			}
	],
	initComponent : function() {
			this.callParent(arguments);
	}
});