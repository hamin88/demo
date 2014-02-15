Ext.Loader.setConfig({
    enabled: true
});

Ext.require([
    'Ext.grid.*',
    'Ext.data.*',
    'Ext.selection.CheckboxModel'
]);

Ext.define('Tax', {
    extend: 'Ext.data.Model',
 fields: ['description', 'taxTypeId.taxTypeName','company.companyName','status.statusName']
       
});
Ext.onReady(function() { 

var store = Ext.create('Ext.data.Store', {
 	
    model: 'Tax',
//    autoLoad: false,
    pageSize: 4,
    proxy: {
        type: 'ajax',
	actionMethods :{create: 'POST', read: 'POST', update: 'POST', destroy: 'POST'},
        url : '../tax/getList',
        reader: {
            type: 'json',
            root: 'data',
            totalProperty: 'total'
        }
    }
});
Ext.create(Ext.grid.GridPanel, {
title:'Tax list',
    renderTo:'taxView',
             columns: [{
                header: "Description",
                

width: 280,
                sortable: true,
                dataIndex: 'description',
                align: 'left',
             

   menuDisabled: true,
                renderer: this.nameRenderer
            }, {
                header: "Tax type",
    

            width: 280,
                sortable: true,
                dataIndex: 'taxTypeId.taxTypeName',
                align: 

'left',
                menuDisabled: true 
            }, {
				header : "Company",

				width : 280,
				sortable : true,
				dataIndex : 'company.companyName',
				align :

				'left',
				menuDisabled : true
			}, {
				header : "Status",

				width : 280,
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