Ext.onReady(function() {
        var roleStore = new Ext.role.RoleStore("getList");
        var roleGrid = new Ext.role.RoleGrid(roleStore);
        var langGridTitle = "Role";
        var rolePanel = new Ext.Panel({
            layout: 'form',
            title: langGridTitle,
            items:  [roleGrid]
        });
        rolePanel.render('roleView');
});