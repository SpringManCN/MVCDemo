/**
 * The main application class. An instance of this class is created by app.js when it calls
 * Ext.application(). This is the ideal place to handle application launch and initialization
 * details.
 */
Ext.define('Demo.Application', {
    extend: 'Ext.app.Application',
    
    name: 'Demo',

    views: [
        // TODO: add views here
        'Demo.main.view.MainModel'
    ],

    controllers: [
        // TODO: add controllers here
        'Demo.main.view.MainController'
    ],

    stores: [
        // TODO: add stores here
    ],
    
    launch: function () {
        // TODO - Launch the application
    }
});
