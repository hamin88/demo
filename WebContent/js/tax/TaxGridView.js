Ext.onReady(function() {
        var taxStore = new Ext.tax.TaxStore("getList");
        var taxGrid = new Ext.tax.TaxGrid(taxStore);
        var langGridTitle = "Tax";
        var taxPanel = new Ext.Panel({
            layout: 'form',
            title: langGridTitle,
            items:  [taxGrid]
        });
        taxPanel.render('taxView');
});