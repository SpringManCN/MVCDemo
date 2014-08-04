/**
 * 系统主页的底部区域，主要放置用户单位信息，服务单位和服务人员信息
 */
Ext.define('app.view.main.region.Bottom', {

			extend : 'Ext.toolbar.Toolbar',

			alias : 'widget.mainbottom',

			uses : ['app.ux.ButtonTransparent'],

			style : 'background-color : #cde6c7',
			height : 40,
			
			defaults : {
				xtype : 'buttontransparent'
			},

			style : 'background: #f6f5ec;',

			items : [{
				xtype : 'label',
				text : '系统版本：V1.0' ,// text值绑定到system.name
				style : 'font-size:20px;color:#157fcc;'
			}, {
			},  '->', '->', {
				text : '技术人员：段云龙',
				glyph : 0xf007
			}, {
				text : '362852150@qq.com',
				glyph : 0xf011
			}, ]
		});