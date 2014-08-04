<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Extjs MVC</title>
<style type="text/css">  
body,html{height:100%;margin:0px;padding:0px;}  
#outer{height:100%;overflow:hidden;position:relative;width:100%;}  
#outer[id] {display:table;position:static;}  
#middle {position:absolute;top:50%;left:50%;}  
#middle[id]{display:table-cell;vertical-align:middle;position:static;}  
#inner{position:relative;top:-50%;width:310px;left:50% !important;left:-155px;}  
#container{width:310px;height:190px;margin-left:auto;margin-right:auto;}  
</style>  

<!-- 引入Font Awesome的css文件 -->  
<link type="text/css" rel="stylesheet" href="resouces/font-awesome-4.1.0/css/font-awesome.css">  

<script type="text/javascript" src="resouces/ext-4.2/bootstrap.js"></script>
<script type="text/javascript" src="resouces/ext-4.2/locale/ext-lang-zh_CN.js"></script>
<link  rel="stylesheet" href="resouces/ext-4.2/resources/css/ext-all-neptune.css"/>


<script type="text/javascript">  
Ext.onReady(function () {
    //begin
    var logf = new Ext.FormPanel({
    	standardSubmit: true,//关键设置，只有设置了才能跳转，而不是把返回的网页当成json字符串解析
        renderTo: "log",
        url:"/Demo/login",  
        title: "用户登录",
        width: 300,
        height: 150,
        frame: true,
        floating: true,
        defaultType: "textfield",
        labelAlign: "right",
        
        items: [
        {
            fieldLabel: "用户名",
            name:"userName",
            id:"userName",
            allowBlank : false //是否可以为空
        },
        {
			xtype : 'textfield',
			fieldLabel : '密码',
			name:'password',
			id : "password",
			inputType: 'password',
			allowBlank : false
		}
        ],
        buttons: [{ text: "登录", handler: function () {
        	if (!logf.getForm().isValid()) return;  
            
        	logf.getForm().submit();  
        }
        }, { 
        	text: "重置" ,
        	handler: function(){
        		//var formObj = Ext.getCmp("logf");
			  	var basic = logf.getForm();
			  	basic.reset();
        	}}]


    });
    //end
    var vp = new Ext.Viewport();
    var x = (vp.getSize().width - logf.getSize().width) / 2;
    var y = (vp.getSize().height - logf.getSize().height) / 2;
    logf.setPosition(x, y);

}) 
</script>  
</head>  
<body>  
	<div id="log"></div>
</body>  
</html>  