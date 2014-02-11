 
// @require @packageOverrides
Ext.Loader.setConfig({
    enabled: true
});


Ext.application({

    requires: [
        'Ext.window.MessageBox'
    ],
    models: [
        'Record'
    ],
    stores: [
        'Records'
    ],
    views: [
        'RecordForm',
        'MainView'
    ],
    controllers: [
        'Records'
    ],
    name: 'MyApp',

    launch: function() {
        Ext.create('MyApp.view.MainView');
    }

});
