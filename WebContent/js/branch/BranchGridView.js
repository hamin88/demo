Ext.onReady(function() {
        var branchStore = new Ext.branch.BranchStore("getList");
        var branchGrid = new Ext.branch.BranchGrid(branchStore);
        var langGridTitle = "Branch";
        var branchPanel = new Ext.Panel({
            layout: 'form',
            title: langGridTitle,
            items:  [branchGrid]
        });
        branchPanel.render('branchView');
});