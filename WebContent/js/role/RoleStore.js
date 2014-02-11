Ext.ns("Ext.role");
Ext.role.RoleStore = Ext.extend(Ext.data.Store, {
    autoLoad: false,
    remoteSort: true,
    reader: new Ext.data.JsonReader({
        root: 'data',
        totalProperty: 'total',
        fields: ['roleName', 'description']
    }),

    constructor: function(url) {
        this.proxy = new Ext.data.HttpProxy({
            url: url
        });

        Ext.role.RoleStore.superclass.constructor.apply(this, arguments);
    },
    baseParams: {
        start: 0,
        limit: 5
    }
});