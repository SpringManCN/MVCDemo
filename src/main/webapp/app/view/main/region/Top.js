/**
 * 系统主页的顶部区域，主要放置系统名称，菜单，和一些快捷按钮
 */
Ext.define('app.view.main.region.Top', {
			extend : 'Ext.toolbar.Toolbar',
			alias : 'widget.maintop', // 定义了这个组件的xtype类型为maintop
			uses : ['app.ux.ButtonTransparent'],
			defaults : {
				xtype : 'buttontransparent'
			},
			style : 'background-color : #cde6c7',
			height : 40,
			items : [{
						xtype : 'label',
						text : '小白后台管理系统' ,// text值绑定到system.name
						style : 'font-size:20px;color:#157fcc;'
					}, {
					},  '->', '->', {
						text : '段云龙',
						//html:"${user.username}",
						glyph : 0xf007
					}, {
						text : '注销',
						glyph : 0xf011
					}, ]

		});