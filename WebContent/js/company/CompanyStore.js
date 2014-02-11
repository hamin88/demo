Ext.ns("Ext.company");
Ext.company.CompanyStore = Ext.extend(Ext.data.Store, {
    autoLoad: false,
    remoteSort: true,
    reader: new Ext.data.JsonReader({
        root: 'data',
        totalProperty: 'total',
        fields: ['companyName', 'city','state','country','email','website','gstNo','cstNo']
    }),

    constructor: function(url) {
        this.proxy = new Ext.data.HttpProxy({
            url: url
        });

        Ext.company.CompanyStore.superclass.constructor.apply(this, arguments);
    },
    baseParams: {
        start: 0,
        limit: 5
    }
});