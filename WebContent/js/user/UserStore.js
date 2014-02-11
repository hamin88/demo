Ext.ns("Ext.user");
Ext.user.UserStore = Ext.extend(Ext.data.Store, {
    autoLoad: false,
    remoteSort: true,
    reader: new Ext.data.JsonReader({
        root: 'data',
        totalProperty: 'total',
        fields: ['id', 'firstName','lastName','mobile','email','role.roleName','status.statusName']
    }),

    constructor: function(url) {
        this.proxy = new Ext.data.HttpProxy({
            url: url
        });

        Ext.user.UserStore.superclass.constructor.apply(this, arguments);
    },
    baseParams: {
        start: 0,
        limit: 5
    }
});