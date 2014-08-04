Ext.define('app.model.userManage.UserModel',{
	extend:'Ext.data.Model',
	fields:[
		{name:'uuid',type:'string'},
		{name:'userName',type:'string'},
		{name:'realName',type:'string'},
		{name:'roleName',type:'string'},
		{name:'roleId',type:'string'},
		{name:'departName',type:'string'},
		{name:'departId',type:'string'},
	],
	
	//hasMany: {model: 'RoleModel',name: 'roles'}
});