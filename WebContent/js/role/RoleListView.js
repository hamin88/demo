Ext.Loader.setConfig({
    enabled: true
});

Ext.require([
    'Ext.grid.*',
    'Ext.data.*',
    'Ext.selection.CheckboxModel'
]);

Ext.define('Role', {
    extend: 'Ext.data.Model',
    fields:  ['id', 'roleName','description']

});
Ext.onReady(function() { 

var store = Ext.create('Ext.data.Store', {
 	
    model: 'Role',
    autoLoad: false,
    pageSize: 4,
    proxy: {
        type: 'ajax',
	actionMethods :{create: 'POST', read: 'POST', update: 'POST', destroy: 'POST'},
        url : '../role/getList',
        reader: {
            type: 'json',
            root: 'data',
            totalProperty: 'total'
        }
    }
});
Ext.create(Ext.grid.GridPanel, {
title:'Role list',
    renderTo:'roleView',
 			columns : [ {
				text : "Role Name",
				width : 340,
				sortable : true,
				dataIndex : 'roleName',
				align : 'left',
 			}, {
				text : "Description",
				width : 340,
				sortable : true,
				dataIndex : 'description',
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