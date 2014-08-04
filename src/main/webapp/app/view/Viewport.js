Ext.define('app.view.Viewport', {
    extend: 'Ext.container.Viewport',
    //布局方式：border
    layout: 'border',
    items: [{
    	region:'north',
    	xtype:'maintop'
    },{
    	region:'south',
    	xtype:'mainbottom'
    },{
    	title:'功能菜单',
		region:'west',
		width:200,
		collapsible:true,
		split:true,
		items:[{
			id:'menuTree',
			xtype:'menuTree'
		}]
    }, {  
    	id:'tabPanel',
        region : 'center', // 中间面版  
        xtype : 'tabpanel',  
        items : [{  
        	glyph : 0xf015,
        	title : 'Tab 1',  
        	html : '<button type="button" class="btn btn-success">Success</button>'  
        }]  
    }],
    
    initComponent : function() {  
        Ext.setGlyphFontFamily('FontAwesome'); // 设置图标字体文件，只有设置了以后才能用glyph属性  
        this.callParent();  
    },  
});