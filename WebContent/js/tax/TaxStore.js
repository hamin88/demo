Ext.ns("Ext.tax");
Ext.tax.TaxStore = Ext.extend(Ext.data.Store, {
    autoLoad: false,
    remoteSort: true,
    reader: new Ext.data.JsonReader({
        root: 'data',
        totalProperty: 'total',
        fields: ['description', 'taxTypeId.taxTypeName','company.companyName','status.statusName']
    }),

    constructor: function(url) {
        this.proxy = new Ext.data.HttpProxy({
            url: url
        });

        Ext.tax.TaxStore.superclass.constructor.apply(this, arguments);
    },
    baseParams: {
        start: 0,
        limit: 5
    }
});