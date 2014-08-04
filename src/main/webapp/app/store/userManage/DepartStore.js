Ext.define('app.store.userManage.DepartStore',{
	 extend:'Ext.data.TreeStore',
     defaultRoodId:'root',
     model:'app.model.userManage.DepartModel',
     proxy: {
		 autoLoad: true,
         type: 'ajax',
         url: '/Demo/depart/findAll',
         reader: 'json',
        	//传参  
         extraParams : {  
        	 uuid : ''  
         }
     },

     listeners : {  
	    'beforeexpand' : function(node,eOpts){  
	    	//点击父亲节点的菜单会将节点的id通过ajax请求，将到后台
	    	
	        this.proxy.extraParams.uuid = node.raw.uuid;  
	    } ,
	    
	    /*'beforeload': function( store, operation, eOpts ){
	    	 this.proxy.extraParams.uuid = "";  
	    }*/
	}
});