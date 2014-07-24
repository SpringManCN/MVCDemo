/**
 * This class is the view model for the Main view of the application.
 */
Ext.define('Demo.view.main.MainModel', {
    extend: 'Ext.app.ViewModel',

    alias: 'viewmodel.main',

    data: {
        name: 'Demo',
        
        //系统信息
        system:{
        	name:'EXTJS5例子',
        	version:'1.0',
        	iconUrl:''
        },
        
        //用户信息
		user:{
			name:'奥巴马',
			company:'XXX有限公司',
			department:'工程部'
		},
		
		//服务单位和服务人员信息
		service:{
			 company : 'ooo公司',  
	         name : 'dyl',  
	         phonenumber : '1320528----',  
	         qq : '362852150',  
	         email : '362852150@qq.com',  
	         copyright : 'ooo公司'  
		}
    }

    //TODO - add data, formulas and/or methods to support your view
});