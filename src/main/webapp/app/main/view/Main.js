/**
 * This class is the main view for the application. It is specified in app.js as the
 * "autoCreateViewport" property. That setting automatically applies the "viewport"
 * plugin to promote that instance of this class to the body element.
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */
Ext.define('Demo.main.view.Main', {
    extend: 'Ext.container.Container',

    //uses:['Demo.view.main.region.Top','Demo.view.main.region.Bottom'],
    
    //xtype: 'app-main',
    
    //controller: 'controller.main',
    
    viewModel: {
        type: 'viewmodel.main'
    },

    layout: {
        type: 'border'
    },

    items: [
      /*{//加入顶部栏
    	xtype: 'mainTop',
    	region:'north'
    },{//加入底部栏
    	xtype: 'mainBottom',
    	region:'south'
    },*/{//左边栏
        xtype: 'panel',
        bind: {
            title: '{name}'
        },
        region: 'west',
        html: '<ul><li>This area is commonly used for navigation, for example, using a "tree" component.</li></ul>',
        width: 250,
        split: true,
        tbar: [{
            text: 'Button',
            handler: 'onClickButton'
        }]
    },{//中间内容
        region: 'center',
        xtype: 'tabpanel',
        items:[{
            title: 'Tab 1',
            html: '<h2>Content appropriate for the current navigation.</h2>'
        }]
    }],
    
   /* initComponent : function() {  
        Ext.setGlyphFontFamily('FontAwesome'); // 设置图标字体文件，只有设置了以后才能用glyph属性  
        this.callParent();  
    }, */
});
