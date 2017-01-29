'use strict';

/**
 * @ngdoc function
 * @name employeeWebApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the employeeWebApp
 */
angular.module('employeeWebApp')
    .controller('MainCtrl', function($scope, EmployeeService, EmployeeModalService) {

        EmployeeService.getAll().then(function(response) {
            $scope.smartTableData = response.result;
            $scope.displayedCollection = [].concat(response.result);
        }, function(response) {
            // handle error and update ui
            console.log(response);
        });

        $scope.editEmployee = function(employee) {
            EmployeeModalService.open(employee).result.then(function() {
                console.log(employee);
                return EmployeeService.update(employee.employeeId, assembleRequest(employee));
            }, function() {
                // cancel button handler
            }).then(function(response) {
                if (!response) {
                    return;
                }
                // handle update success/failure
                console.log(response);
            });
        }

        $scope.deleteEmployee = function(employee) {

            EmployeeService.delete(employee.employeeId).then(function() {
                var index = _.findIndex($scope.smartTableData, function(emp) {
                    return emp.employeeId == employee.employeeId;
                });
                $scope.smartTableData.splice(index, 1);
            }, function() {
                // handle delete failure
            });
        }

        $scope.addEmployee = function() {
            var employee = {};
            EmployeeModalService.open(employee).result.then(function() {
                console.log(employee);
                return EmployeeService.create(assembleRequest(employee));
            }, function() {
                // cancel button handler
            }).then(function(response) {
                if (!response) {
                    return;
                }
                // handle update success/failure
                console.log(response);
                $scope.smartTableData.push(employee);
            });
        }

        function assembleRequest(employee) {
            return {
                name: employee.name,
                email: employee.email,
                department: employee.department,
                designation: employee.designation,
                salary: employee.salary
            };
        }
    });