Ext.onReady(function() {
        var userStore = new Ext.user.UserStore("getList");
        var userGrid = new Ext.user.UserGrid(userStore);
        var langGridTitle = "User";
        var userPanel = new Ext.Panel({
            layout: 'form',
            title: langGridTitle,
            items:  [userGrid]
        });
        userPanel.render('userView');
});