Ext.ns("Ext.branch");
Ext.branch.BranchGrid = Ext.extend(Ext.grid.GridPanel, {
	constructor : function(store) {
		var

		me = this;

		Ext.apply(this, {
			columns : [ {
				header : "Branch Name",

				width : 280,
				sortable : true,
				dataIndex : 'branchName',
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
				header : "Company",

				width : 280,
				sortable : true,
				dataIndex : 'company.companyName',
				align :

				'left',
				menuDisabled : true
			},{
				header : "Email",

				width : 280,
				sortable : true,
				dataIndex : 'email',
				align :

				'left',
				menuDisabled : true
			},{
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
			} , {
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

		Ext.branch.BranchGrid.superclass.constructor.apply(this, arguments);
	}
});