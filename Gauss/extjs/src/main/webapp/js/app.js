/**
 * Created by M S on 8/23/2015.
 */

//Ext.application({
//
//       name : 'tutorial',
//       launch : function() {
//           Ext.create('Ext.container.Viewport', {
//               layout: 'fit',
//               items: [
//                   {
//                       title: 'First Extjs Application - Viewport title',
//                       html: 'Application Viewport area'
//                   }
//               ]
//           });
//       }
//});


Ext.onReady(function() {

    Ext.define('User', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'name', type: 'string'},
            {name: 'due', type: 'string'},
            {name: 'lastmodified', mapping: 'availability', type: 'date', dateFormat: 'm/d/Y'}
        ],
        idProperty: 'name'
    });

    var myStore = Ext.create('Ext.data.Store', {
        //pageSize: 10,
        model: 'User',
        autoLoad: 'true',
        proxy: {
            type: 'ajax',
//            api: {
//                create : 'users.json',
//                read   : 'users.json',
//                update : 'users.json?update=true',
//                destroy: 'users.json'
//            },
            url: 'users.json',
            reader: {
                type: 'json',
                root: 'users'
            }//,
//            writer: {
//                type: 'json',
//                root: 'users'
//            }
        },
        sorters: [{
            property: 'name',
            direction: 'DESC'
        }],
        buttons: [{
            text: 'Submit',
            action: 'submit'
        },{
            text: 'load',
            action: 'login'
        }]
    });

    var cellEditing = Ext.create('Ext.grid.plugin.CellEditing', {
        clicksToEdit: 1
    });

    var grid = Ext.create('Ext.grid.Panel', {
        width: 700,
        height: 500,
        title: 'wow!',
        store: myStore,
        columns: [{
            id: 'name',
            text: "name",
            dataIndex: 'name'
        },{
            id: 'due',
            header: "due amount",
            flex: 1,
            //sortable: true,
            dataIndex: 'due',
            width: 130,
            field: {
                allowBlank : false
            }
        }],
        renderTo: Ext.getBody(),
        frame: true,
//        tbar: [{
//            text: 'Save',
//            handler: function () {
//                myStore.sync();
//            }
//        }],
        plugins: [cellEditing],
        buttons: [{
            text: 'Submit',
            action: 'submit'
        },{
            text: 'show',
            action: 'show'
        }]
    });

//    grid.on('edit', function(editor, e){
//        alert(editor.store)
//        editor.store.sync();
//    })

        Ext.define('MyAjaxApp.controller.AjaxExample', {
            extend : 'Ext.app.Controller',
            views : grid,
            onSubmitRequest : function(button) {
                console.log('Login submit Request in progress');
            }
        })

});
