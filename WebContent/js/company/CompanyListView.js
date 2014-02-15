Ext.Loader.setConfig({
    enabled: true
});

Ext.require([
    'Ext.grid.*',
    'Ext.data.*',
    'Ext.selection.CheckboxModel'
]);

Ext.define('Company', {
    extend: 'Ext.data.Model',
    fields:  ['companyName', 'city','state','country','email','website','gstNo','cstNo']

});
Ext.onReady(function() { 

var store = Ext.create('Ext.data.Store', {
 	
    model: 'Company',
    autoLoad: false,
    pageSize: 4,
    proxy: {
        type: 'ajax',
	actionMethods :{create: 'POST', read: 'POST', update: 'POST', destroy: 'POST'},
        url : '../company/getList',
        reader: {
            type: 'json',
            root: 'data',
            totalProperty: 'total'
        }
    }
});
Ext.create(Ext.grid.GridPanel, {
title:'Company list',
    renderTo:'companyView',
 
columns : [ {
				header : "Company Name",

				width : 130,
				sortable : true,
				dataIndex : 'companyName',
				align : 'left',

				menuDisabled : true,
				renderer : this.nameRenderer
			}, {
				header : "Address",

				width : 130,
				sortable : true,
				dataIndex : 'city',
				align :

				'left',
				menuDisabled : true
			}, {
				header : "Email",

				width : 130,
				sortable : true,
				dataIndex : 'email',
				align :

				'left',
				menuDisabled : true
			}, {
				header : "website",

				width : 110,
				sortable : true,
				dataIndex : 'website',
				align :

				'left',
				menuDisabled : true
			}, {
				header : "GST No.",

				width : 70,
				sortable : true,
				dataIndex : 'gstNo',
				align :

				'left',
				menuDisabled : true
			}, {
				header : "CST No.",

				width : 70,
				sortable : true,
				dataIndex : 'cstNo',
				align :

				'left',
				menuDisabled : true
			} ],
			loadMask : true,
			remoteSort : true,

			// height: 140,
			autoHeight : true,
			store : store,
			viewConfig : {
				forceFit : true,

				scrollOffset : 0
			},
			listeners : {
				afterrender : function(formpanel) {

					store.removeAll();
					store.load();
				}
			}
		});
 
});