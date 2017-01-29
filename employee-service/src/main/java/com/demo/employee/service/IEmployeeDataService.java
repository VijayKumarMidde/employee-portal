package com.demo.employee.service;

import java.util.List;

import com.demo.employee.entity.model.Employee;

public interface IEmployeeDataService {

	public Employee createEmployee(Employee employee);

	public Employee getEmployeeById(int empId);

	List<Employee> getAllActiveEmployees();

	Employee updateEmployee(Employee employee);

	void deleteEmployee(int employeeId);
	
}