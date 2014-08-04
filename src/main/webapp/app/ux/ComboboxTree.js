/**
 * 下拉菜单和树的结合
 */
Ext.define('app.ux.ComboboxTree', {
    extend: 'Ext.form.field.ComboBox',
    alias : "widget.comboxBoxTree",
    url: '',
    modelStr: '',
    tree: {},
    textProperty: 'text',
    valueProperty: '',
    valueField:'uuid',
    initComponent: function () {
        Ext.apply(this, {
            editable: false,
            queryMode: 'local',
            select: Ext.emptyFn
        });

        this.displayField = this.displayField || 'text',
        this.treeid = Ext.String.format('tree-combobox-{0}', Ext.id());
        this.tpl = Ext.String.format('<div id="{0}"></div>', this.treeid);

        if (this.url) {
            var me = this;
            var store = Ext.create('Ext.data.TreeStore', {
            	defaultRoodId:'root',
                model:this.modelStr,
                proxy: {
           		 autoLoad: true,
                    type: 'ajax',
                    url: this.url,
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
           	    }  
           	}
            });
            this.tree = Ext.create('Ext.tree.Panel', {
                rootVisible: false,
                autoScroll: true,
                height: 200,
                store: store
            });
            this.tree.on('itemclick', function (view, record) {
                me.setValue(record);
                me.collapse();
            });
            me.on('expand', function () {
                if (!this.tree.rendered) {
                    this.tree.render(this.treeid);
                }
            });
        }
        this.callParent(arguments);
    }
});