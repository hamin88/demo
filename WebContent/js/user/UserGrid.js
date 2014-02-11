Ext.ns("Ext.user");
Ext.user.UserGrid = Ext.extend(Ext.grid.GridPanel, {
	constructor : function(store) {
		var

		me = this;

		Ext.apply(this, {
			columns : [ {
				header : "User Name",

				width : 280,
				sortable : true,
				dataIndex : 'firstName',
				align : 'left',

				menuDisabled : true,
				renderer : this.nameRenderer
			}, {
				header : "Mobile",

				width : 280,
				sortable : true,
				dataIndex : 'mobile',
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
				header : "Role",

				width : 280,
				sortable : true,
				dataIndex : 'role.roleName',
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

		Ext.user.UserGrid.superclass.constructor.apply(this, arguments);
	}
});