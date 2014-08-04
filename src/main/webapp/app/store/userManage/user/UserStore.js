Ext.define('app.store.userManage.user.UserStore',{
	extend:'Ext.data.Store',
	model:'app.model.userManage.UserModel',
	proxy: {
		 autoLoad: true,
        type: 'ajax',
        url: '/Demo/user/findAll',
        reader: 'json'
    },
	autoLoad:true
});