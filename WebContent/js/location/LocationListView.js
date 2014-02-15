Ext.Loader.setConfig({
    enabled: true
});

Ext.require([
    'Ext.grid.*',
    'Ext.data.*',
    'Ext.selection.CheckboxModel'
]);

Ext.define('Location', {
    extend: 'Ext.data.Model',
    fields: ['locationName', 'company.companyName','location.locationName'] 
    
});
Ext.onReady(function() { 

var store = Ext.create('Ext.data.Store', {
 	
    model: 'Location',
//    autoLoad: false,
    pageSize: 4,
    proxy: {
        type: 'ajax',
	actionMethods :{create: 'POST', read: 'POST', update: 'POST', destroy: 'POST'},
        url : '../location/getList',
        reader: {
            type: 'json',
            root: 'data',
            totalProperty: 'total'
        }
    }
});
Ext.create(Ext.grid.GridPanel, {
title:'Location list',
    renderTo:'locationView',
    columns : [ {
		header : "Location Name",

		width : 220,
		sortable : true,
		dataIndex : 'locationName',
		align : 'left',

		menuDisabled : true,
		renderer : this.nameRenderer
	},{
		header : "Company",

		width : 220,
		sortable : true,
		dataIndex : 'company.companyName',
		align :

		'left',
		menuDisabled : true
	},{
		header : "Branch",

		width : 220,
		sortable : true,
		dataIndex : 'branch.branchName',
		align :

		'left',
		menuDisabled : true
	}],
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