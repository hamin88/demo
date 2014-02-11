 // Create a standard HttpProxy instance.
 var proxy = new Ext.data.HttpProxy({
     url: '../role/getList',
     api2: {
         read: '../role/getList',
         update: undefined,
         create: '../role/save',
         destroy: '../role/delete'
     }


 });

 // Typical JsonReader.  Notice additional meta-data params for defining the core attributes of your json-response
 var reader = new Ext.data.JsonReader({
     totalProperty: 'total',
     successProperty: 'success',
     idProperty: 'id',
     root: 'data',
     messageProperty: 'message' // <-- New "messageProperty" meta-data
 }, [{
     name: 'id'
 }, {
     name: 'roleName',
     allowBlank: false
 }, {
     name: 'description',
     allowBlank: false
 }]);

 // The new DataWriter component.
 var writer = new Ext.data.JsonWriter({
     encode: true,
     writeAllFields: false,
     updateRecord: function (a) {
         console.log(a)
         Ext.Ajax.request({
             url: '../role/save/' + a.id,
             method: 'POST',
             params: {
                 data: Ext.util.JSON.encode(a.data),
             },
             success: function (response, opts) {

             },
             failure: function (response, opts) {
                 // console.log('server-side failure with status code ' + response.status);
             }
         });
     }
 });

 // Typical Store collecting the Proxy, Reader and Writer together.
 var store = new Ext.data.Store({
     id: 'role',
     //restful: true,     // <-- This Store is RESTful
     proxy: proxy,
     reader: reader,
     writer: writer // <-- plug a DataWriter into the store just as you would a Reader
 });

 // load the store immeditately
 store.load();

 ////
 // ***New*** centralized listening of DataProxy events "beforewrite", "write" and "writeexception"
 // upon Ext.data.DataProxy class.  This is handy for centralizing role-feedback messaging into one place rather than
 // attaching listenrs to EACH Store.
 //
 // Listen to all DataProxy beforewrite events
 //
 Ext.data.DataProxy.addListener('beforewrite', function (proxy, action) {
     // App.setAlert(App.STATUS_NOTICE, "Before " + action);
 });

 ////
 // all write events
 //
 Ext.data.DataProxy.addListener('write', function (proxy, action, result, res, rs) {
     //App.setAlert(true, action + ':' + res.message);
 });

 ////
 // all exception events
 //
 Ext.data.DataProxy.addListener('exception', function (proxy, type, action, options, res) {
     //App.setAlert(false, "Something bad happend while executing " + action);
 });

 // Let's pretend we rendered our grid-columns with meta-data from our ORM framework.
 var roleColumns = [{
     header: "ID",
     width: 40,
     sortable: true,
     dataIndex: 'id'
 }, {
     header: 'Role Name',
     width: 100,
     sortable: true,
     dataIndex: 'roleName',
     editor: new Ext.form.TextField({})
 }, {
     header: 'Description',
     width: 50,
     sortable: true,
     dataIndex: 'description',
     editor: new Ext.form.TextField({})
 }];


 Ext.onReady(function () {
     Ext.QuickTips.init();

     // use RowEditor for editing
     var editor = new Ext.ux.grid.RowEditor({
         saveText: 'Update'
     });

     // Create a typical GridPanel with RowEditor plugin
     var roleGrid = new Ext.grid.GridPanel({
         renderTo: 'roleView',
         iconCls: 'icon-grid',
         frame: true,
         title: 'Roles',
         height: 300,
         store: store,
         plugins: [editor],
         columns: roleColumns,
         tbar: [{
             text: 'Add',
             iconCls: 'silk-add',
             handler: onAdd
         }, '-', {
             text: 'Delete',
             iconCls: 'silk-delete',
             handler: onDelete
         }, '-'],
         viewConfig: {
             forceFit: true
         }
     });

     /**
      * onAdd
      */
     function onAdd(btn, ev) {
         var u = new roleGrid.store.recordType({
             first: '',
             last: '',
             email: ''
         });
         editor.stopEditing();
         roleGrid.store.insert(0, u);
         editor.startEditing(0);
     }
     /**
      * onDelete
      */
     function onDelete() {
         var rec = roleGrid.getSelectionModel().getSelected();
         if (!rec) {
             return false;
         }
         roleGrid.store.remove(rec);
     }

 });