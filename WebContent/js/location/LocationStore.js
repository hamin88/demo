Ext.ns("Ext.location");
Ext.location.LocationStore = Ext.extend(Ext.data.Store, {
    autoLoad: false,
    remoteSort: true,
    reader: new Ext.data.JsonReader({
        root: 'data',
        totalProperty: 'total',
        fields: ['locationName', 'company.companyName','branch.branchName']
    }),

    constructor: function(url) {
        this.proxy = new Ext.data.HttpProxy({
            url: url
        });

        Ext.location.LocationStore.superclass.constructor.apply(this, arguments);
    },
    baseParams: {
        start: 0,
        limit: 5
    }
});