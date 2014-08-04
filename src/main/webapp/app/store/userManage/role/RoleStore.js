Ext.define('app.store.userManage.role.RoleStore',{
	extend:'Ext.data.Store',
	model:'app.model.userManage.RoleModel',
	proxy: {
		 autoLoad: true,
        type: 'ajax',
        url: '/Demo/role/findAll',
        reader: 'json'
    },
	autoLoad:true
});