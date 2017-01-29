'use strict';

/**
 * @ngdoc service
 * @name employeeWebApp.EmployeeModalService
 * @description
 * # EmployeeModalService
 * Factory in the employeeWebApp.
 */
angular.module('employeeWebApp')
    .factory('EmployeeModalService', function($modal) {

        return {
            open: function(employeeObj) {
                return $modal.open({
                    templateUrl: 'views/employee.html',
                    controller: 'EmployeeCtrl',
                    size: 'lg',
                    backdrop: 'static',
                    keyboard: false,
                    resolve: {
                        EmployeeObj: function() {
                            return employeeObj;
                        }
                    }
                });
            }
        };
    });