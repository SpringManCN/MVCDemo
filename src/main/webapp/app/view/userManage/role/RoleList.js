
Ext.define('app.view.userManage.role.RoleList',{
	extend: 'Ext.grid.Panel',
	alias:'widget.roleList',
	id:'roleList',
	selModel : {
		selType : "checkboxmodel"
	},
	border : false,
	multiSelect : true,
	columns:[
			{ text: 'ID',  dataIndex: 'uuid' ,flex: 1,"hidden":true },
			{ text: '名称', dataIndex: 'roleName', flex: 1 },
			{ text: '描述', dataIndex: 'note' ,flex: 1}	
	],
	store:'userManage.role.RoleStore',
	dockedItems: [{
        xtype: 'pagingtoolbar',
        store: 'userManage.role.RoleStore',
        dock: 'bottom',
        displayInfo: true
    }],
	tbar : [{
				xtype : 'button',
				text : '添加角色',
				id : 'addRole'
			},
			{
				xtype : 'button',
				text : '修改角色',
				id : 'updateRole',
			},
			{
				xtype : 'button',
				text : '删除角色',
				id : 'deleteRole',
			},
			"->",
			{
				fieldLabel : "关键字",
				labelWidth : 50,
				width : 150,
				xtype : 'textfield',
				name : "searchmatter",
				id : "r_adminsearchmatter",
				emptyText : "请输入关键字",
				selectOnFocus : true
			},
			{
				xtype : "combobox",
				labelWidth : 60,
				width : 160,
				emptyText : "请选择类型",
				listConfig : { // 控制下拉列表的样式
					emptyText : "没有找到匹配的项",
					maxHeight : 200
				},
				fieldLabel : "搜索类型",
				name : "adminsearchtype",
				id : "r_adminsearchtype",
				queryMode : "local",
				
				valueField : "value",
				displayField : "text",
				forceSelection : true,
						// multiSelect:true,
						typeAhead : true
			},
			{
				xtype : "button",
				id : "r_search",
				iconCls : "search",
				text : "搜索"
			}
		],
		initComponent : function() {
				this.callParent(arguments);
		}
});