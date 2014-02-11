Ext.onReady(function() {
        var locationStore = new Ext.location.LocationStore("getList");
        var locationGrid = new Ext.location.LocationGrid(locationStore);
        var langGridTitle = "Location";
        var locationPanel = new Ext.Panel({
            layout: 'form',
            title: langGridTitle,
            items:  [locationGrid]
        });
        locationPanel.render('locationView');
});