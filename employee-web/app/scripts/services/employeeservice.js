'use strict';

/**
 * @ngdoc service
 * @name employeeWebApp.EmployeeService
 * @description
 * # EmployeeService
 * Service in the employeeWebApp.
 */
angular.module('employeeWebApp')
    .factory('EmployeeService', function(Restangular) {
        return {
        	getById: function(employeeId) {
        		return Restangular.one('employees', employeeId).get();
        	},
        	getAll: function() {
                return Restangular.one('employees').one('all').get();
            },
            update: function(employeeId, requestBody) {
            	return Restangular.one('employees', employeeId).customPUT(requestBody);
            },
            create: function(requestBody) {
            	return Restangular.one('employees').customPOST(requestBody);
            },
            delete: function(employeeId) {
            	return Restangular.one('employees', employeeId).customDELETE();	
            }
        };
    });