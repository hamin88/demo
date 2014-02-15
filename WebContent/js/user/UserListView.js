Ext.Loader.setConfig({
    enabled: true
});

Ext.require([
    'Ext.grid.*',
    'Ext.data.*',
    'Ext.selection.CheckboxModel'
]);

Ext.define('User', {
    extend: 'Ext.data.Model',
    fields:  ['id', 'firstName','lastName','mobile','email','role.roleName','status.statusName']

});
Ext.onReady(function() { 

var store = Ext.create('Ext.data.Store', {
 	
    model: 'User',
    autoLoad: false,
    pageSize: 4,
    proxy: {
        type: 'ajax',
	actionMethods :{create: 'POST', read: 'POST', update: 'POST', destroy: 'POST'},
        url : '../user/getList',
        reader: {
            type: 'json',
            root: 'data',
            totalProperty: 'total'
        }
    }
});
Ext.create(Ext.grid.GridPanel, {
title:'User list',
    renderTo:'userView',
 			columns : [ {
				text : "User Name",

				width : 140,
				sortable : true,
				dataIndex : 'firstName',
				align : 'left',

				menuDisabled : true,
				renderer : this.nameRenderer
			}, {
				text : "Mobile",

				width : 140,
				sortable : true,
				dataIndex : 'mobile',
				align :

				'left',
				menuDisabled : true
			}, {
				text : "Email",

				width : 140,
				sortable : true,
				dataIndex : 'email',
				align :

				'left',
				menuDisabled : true
			}, {
				text : "Role",

				width : 140,
				sortable : true,
				dataIndex : 'role.roleName',
				align :

				'left',
				menuDisabled : true
			}, {
				text : "Status",

				width : 140,
				sortable : true,
				dataIndex : 'status.statusName',
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