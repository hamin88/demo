<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/extjs-3.4/resources/css/ext-all.css" />
 <link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/extjs-3.4/resources/css/xtheme-blue.css" /> 
 <link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/extjs-3.4/ux/css/MultiSelect.css" />
 
<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/extjs-3.4/ux/css/LockingGridView.css" />
<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/extjs-3.4/css/menu_style.css" />
<script type="text/javascript" src="${rc.getContextPath()}/extjs-3.4/js/ext-base.js"></script>
<script type="text/javascript" src="${rc.getContextPath()}/extjs-3.4/js/ext-all.js"></script>
<script type="text/javascript" src="${rc.getContextPath()}/extjs-3.4/js/ApplicationMessage.js"></script>
<script type="text/javascript" src="${rc.getContextPath()}/extjs-3.4/js/ApplicationComponent.js"></script>
 
<script type="text/javascript">

Ext.override(Ext.data.Connection,{
timeout: 600000
});
Ext.override(Ext.grid.CheckboxSelectionModel,{
    handleMouseDown : function(g, rowIndex, e){
        if(e.button !== 0 || this.isLocked()){
            return;
        };
        var view = this.grid.getView();
        if(e.shiftKey && this.last !== false){
            var last = this.last;
            this.selectRange(last, rowIndex, e.ctrlKey);
            this.last = last; // reset the last
            view.focusRow(rowIndex);
        }else{
            var isSelected = this.isSelected(rowIndex);
            if(e.ctrlKey && isSelected){
                this.deselectRow(rowIndex);
            }else if(!isSelected || this.getCount() > 1){
                this.selectRow(rowIndex, true);
                view.focusRow(rowIndex);
            }
        }
    }
});
Ext.override(Ext.grid.RowSelectionModel,{
 onKeyPress : function(e, name){
        var up = name == 'up',
            method = up ? 'selectPrevious' : 'selectNext',
            add = up ? -1 : 1,
            last;
        if(!e.shiftKey || this.singleSelect){
            this[method](true);
        }else if(this.last !== false && this.lastActive !== false){
            last = this.last;
            this.selectRange(this.last,  this.lastActive + add);
            this.grid.getView().focusRow(this.lastActive);
            if(last !== false){
                this.last = last;
            }
        }else{
           this.selectFirstRow();
        }
    }
});


</script>
 