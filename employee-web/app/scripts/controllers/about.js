'use strict';

/**
 * @ngdoc function
 * @name employeeWebApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the employeeWebApp
 */
angular.module('employeeWebApp')
    .controller('AboutCtrl', function($scope) {
        $scope.awesomeThings = [
            'HTML5 Boilerplate',
            'AngularJS',
            'Karma'
        ];
    });