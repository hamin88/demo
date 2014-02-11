Ext.ns("Ext.company");
Ext.company.CompanyGrid = Ext.extend(Ext.grid.GridPanel, {
	constructor : function(store) {
		var

		me = this;

		Ext.apply(this, {
			columns : [ {
				header : "Company Name",

				width : 280,
				sortable : true,
				dataIndex : 'companyName',
				align : 'left',

				menuDisabled : true,
				renderer : this.nameRenderer
			}, {
				header : "Address",

				width : 280,
				sortable : true,
				dataIndex : 'city',
				align :

				'left',
				menuDisabled : true
			}, {
				header : "Email",

				width : 280,
				sortable : true,
				dataIndex : 'email',
				align :

				'left',
				menuDisabled : true
			}, {
				header : "website",

				width : 280,
				sortable : true,
				dataIndex : 'website',
				align :

				'left',
				menuDisabled : true
			}, {
				header : "GST No.",

				width : 280,
				sortable : true,
				dataIndex : 'gstNo',
				align :

				'left',
				menuDisabled : true
			}, {
				header : "CST No.",

				width : 280,
				sortable : true,
				dataIndex : 'cstNo',
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

		Ext.company.CompanyGrid.superclass.constructor.apply(this, arguments);
	}
});