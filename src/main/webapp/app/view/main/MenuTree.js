Ext.define("app.view.main.MenuTree",{
	extend:'Ext.tree.Panel',
	alias: 'widget.menuTree',
	 //是否显示根节点
    rootVisible: false,
	border: false,
	
	store:'menuStore'
});



