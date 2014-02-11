Ext.ns("Ext.location");
Ext.location.LocationGrid = Ext.extend(Ext.grid.GridPanel, {
	constructor : function(store) {
		var

		me = this;

		Ext.apply(this, {
			columns : [ {
				header : "Location Name",

				width : 280,
				sortable : true,
				dataIndex : 'locationName',
				align : 'left',

				menuDisabled : true,
				renderer : this.nameRenderer
			}, {
				header : "Company",

				width : 280,
				sortable : true,
				dataIndex : 'company.companyName',
				align :

				'left',
				menuDisabled : true
			}, {
				header : "Branch",

				width : 280,
				sortable : true,
				dataIndex : 'branch.branchName',
				align :

				'left',
				menuDisabled : true
			} ],
			loadMask : true,
			remoteSort : true,

			// height: 280,
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

		Ext.location.LocationGrid.superclass.constructor.apply(this, arguments);
	}
});