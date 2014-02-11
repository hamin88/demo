/*
 * File: app/view/MainView.js
 *
 * This file was generated by Sencha Architect version 3.0.2.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 4.2.x library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 4.2.x. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('MyApp.view.MainView', {
    extend: 'Ext.container.Viewport',

    requires: [
        'Ext.toolbar.Toolbar',
        'Ext.form.Label',
        'Ext.button.Button',
        'Ext.grid.Panel',
        'Ext.grid.column.Number',
        'Ext.grid.column.Date',
        'Ext.form.field.Date',
        'Ext.grid.column.Boolean',
        'Ext.form.field.Checkbox',
        'Ext.grid.plugin.RowEditing',
        'Ext.toolbar.Separator',
        'Ext.XTemplate'
    ],

    id: 'mainView',
    layout: 'fit',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'panel',
                    itemId: 'mainPanel',
                    resizable: false,
                    layout: 'border',
                    collapsed: false,
                    manageHeight: false,
                    title: 'My Records',
                    dockedItems: [
                        {
                            xtype: 'toolbar',
                            dock: 'top',
                            itemId: 'mainToolbar',
                            items: [
                                {
                                    xtype: 'label'
                                },
                                {
                                    xtype: 'button',
                                    itemId: 'addButton',
                                    icon: 'resources/images/add.png',
                                    text: 'Add Record'
                                }
                            ]
                        }
                    ],
                    items: [
                        {
                            xtype: 'gridpanel',
                            flex: 1,
                            region: 'west',
                            split: true,
                            border: '2 2 2 2',
                            id: '',
                            itemId: 'gridPanel',
                            width: 195,
                            resizable: false,
                            bodyBorder: true,
                            forceFit: true,
                            store: 'Records',
                            columns: [
                                {
                                    xtype: 'numbercolumn',
                                    dataIndex: 'id',
                                    text: 'ID',
                                    format: '0'
                                },
                                {
                                    xtype: 'gridcolumn',
                                    dataIndex: 'title',
                                    text: 'Title',
                                    editor: {
                                        xtype: 'textfield'
                                    }
                                },
                                {
                                    xtype: 'datecolumn',
                                    dataIndex: 'date',
                                    text: 'Date',
                                    editor: {
                                        xtype: 'datefield'
                                    }
                                },
                                {
                                    xtype: 'booleancolumn',
                                    dataIndex: 'isFeatured',
                                    text: 'Is Featured',
                                    editor: {
                                        xtype: 'checkboxfield'
                                    }
                                }
                            ],
                            plugins: [
                                Ext.create('Ext.grid.plugin.RowEditing', {

                                })
                            ]
                        },
                        {
                            xtype: 'panel',
                            flex: 1,
                            region: 'center',
                            split: true,
                            border: '2 2 2 2',
                            data: {
                                
                            },
                            itemId: 'detailsPanel',
                            tpl: [
                                '<tpl if="values.id">',
                                '    <h1>{title}</h1>',
                                '    <p>',
                                '        {description}',
                                '    </p>',
                                '</tpl>',
                                '',
                                '<tpl if="!values.id">',
                                '    <h1>Please select a record</h1>',
                                '</tpl>'
                            ],
                            resizable: false,
                            layout: 'fit',
                            bodyBorder: true,
                            bodyPadding: '10 10 10 10',
                            manageHeight: false,
                            dockedItems: [
                                {
                                    xtype: 'toolbar',
                                    dock: 'top',
                                    hidden: true,
                                    itemId: 'detailsToolbar',
                                    items: [
                                        {
                                            xtype: 'button',
                                            itemId: 'editButton',
                                            icon: 'resources/images/edit.png',
                                            text: 'Edit'
                                        },
                                        {
                                            xtype: 'tbseparator'
                                        },
                                        {
                                            xtype: 'button',
                                            itemId: 'removeButton',
                                            icon: 'resources/images/delete.png',
                                            text: 'Delete'
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});