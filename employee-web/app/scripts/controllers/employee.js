'use strict';

/**
 * @ngdoc function
 * @name employeeWebApp.controller:EmployeeCtrl
 * @description
 * # EmployeeCtrl
 * Controller of the employeeWebApp
 */
angular.module('employeeWebApp')
    .controller('EmployeeCtrl', function($scope, $modalInstance, EmployeeObj) {

        $scope.employee = EmployeeObj;
        console.log($scope.employee);

        $scope.add = function() {
        	$modalInstance.close();
        }

		$scope.cancel = function() {
        	$modalInstance.dismiss('');
        }        
    });