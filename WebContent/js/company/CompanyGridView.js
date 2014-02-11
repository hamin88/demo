Ext.onReady(function() {
        var companyStore = new Ext.company.CompanyStore("getList");
        var companyGrid = new Ext.company.CompanyGrid(companyStore);
        var langGridTitle = "Company";
        var companyPanel = new Ext.Panel({
            layout: 'form',
            title: langGridTitle,
            items:  [companyGrid]
        });
        companyPanel.render('companyView');
});