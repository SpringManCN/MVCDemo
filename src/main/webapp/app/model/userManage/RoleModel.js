Ext.define('app.model.userManage.RoleModel',{
	extend:'Ext.data.Model',
	fields:[
		{name:'uuid',type:'string'},
		{name:'roleName',type:'string'},
		{name:'note',type:'string'},
		
	],
	//belongsTo: {type: 'belongsTo', model: 'UserModel'}
});