'use strict';

/**
 * @ngdoc overview
 * @name employeeWebApp
 * @description
 * # employeeWebApp
 *
 * Main module of the application.
 */
angular
    .module('employeeWebApp', [
        'restangular',
        'ngRoute',
        'smart-table',
        'ui.bootstrap'
    ])
    .config(function($routeProvider, $httpProvider, RestangularProvider) {
        
        RestangularProvider.setBaseUrl('http://localhost:8080/employee-api/');
        RestangularProvider.setDefaultHeaders({'Content-Type': 'application/json'});

        $routeProvider
            .when('/', {
                templateUrl: 'views/main.html',
                controller: 'MainCtrl'
            })
            .when('/about', {
                templateUrl: 'views/about.html',
                controller: 'AboutCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });

        $httpProvider.defaults.useXDomain = true;
        delete $httpProvider.defaults.headers.common['X-Requested-With'];
    });