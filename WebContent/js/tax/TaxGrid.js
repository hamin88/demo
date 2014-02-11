Ext.ns("Ext.tax");
Ext.tax.TaxGrid = Ext.extend(Ext.grid.GridPanel, {
        constructor: function(store) {
        var 

me = this;
        
        Ext.apply(this, {
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
            loadMask: true,
            remoteSort: true,
          

  //height: 280,
            autoHeight: true,
            store: store,
            viewConfig: {
        	forceFit:true,
     

           scrollOffset: 0
            },
            listeners: {
                afterrender: function(formpanel) {
         

           store.removeAll();                 
                    store.load(); 
                }
            }
        });
  

      Ext.tax.TaxGrid.superclass.constructor.apply(this, arguments);
    }
});