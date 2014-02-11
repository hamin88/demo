Ext.ns("Ext.role");
Ext.role.RoleGrid = Ext.extend(Ext.grid.GridPanel, {
        constructor: function(store) {
        var 

me = this;
        
        Ext.apply(this, {
            columns: [{
                header: "Role Name",
                

width: 280,
                sortable: true,
                dataIndex: 'roleName',
                align: 'left',
             

   menuDisabled: true,
                renderer: this.nameRenderer
            }, {
                header: "description",
    

            width: 280,
                sortable: true,
                dataIndex: 'description',
                align: 

'left',
                menuDisabled: true 
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
  

      Ext.role.RoleGrid.superclass.constructor.apply(this, arguments);
    }
});