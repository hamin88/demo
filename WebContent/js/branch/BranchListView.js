Ext.Loader.setConfig({
    enabled: true
});

Ext.require([
    'Ext.grid.*',
    'Ext.data.*',
    'Ext.selection.CheckboxModel'
]);

Ext.define('Branch', {
    extend: 'Ext.data.Model',
    fields: ['branchName', 'city','state','country','email','website','gstNo','cstNo','company.companyName','status.statusName']

});
Ext.onReady(function() { 

var store = Ext.create('Ext.data.Store', {
 	
    model: 'Branch',
    autoLoad: false,
    pageSize: 4,
    proxy: {
        type: 'ajax',
	actionMethods :{create: 'POST', read: 'POST', update: 'POST', destroy: 'POST'},
        url : '../branch/getList',
        reader: {
            type: 'json',
            root: 'data',
            totalProperty: 'total'
        }
    }
});
Ext.create(Ext.grid.GridPanel, {
title:'Branch list',
    renderTo:'branchView',
    columns : [ {
		header : "Branch Name",

		width : 120,
		sortable : true,
		dataIndex : 'branchName',
		align : 'left',

		menuDisabled : true,
		renderer : this.nameRenderer
	}, {
		header : "Address",

		width : 120,
		sortable : true,
		dataIndex : 'city',
		align :

		'left',
		menuDisabled : true
	}, {
		header : "Company",

		width : 120,
		sortable : true,
		dataIndex : 'company.companyName',
		align :

		'left',
		menuDisabled : true
	},{
		header : "Email",

		width : 120,
		sortable : true,
		dataIndex : 'email',
		align :

		'left',
		menuDisabled : true
	},{
		header : "GST No.",

		width : 120,
		sortable : true,
		dataIndex : 'gstNo',
		align :

		'left',
		menuDisabled : true
	}, {
		header : "CST No.",

		width : 120,
		sortable : true,
		dataIndex : 'cstNo',
		align :

		'left',
		menuDisabled : true
	} , {
		header : "Status",

		width : 120,
		sortable : true,
		dataIndex : 'status.statusName',
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