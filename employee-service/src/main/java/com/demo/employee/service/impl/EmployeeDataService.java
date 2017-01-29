package com.demo.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.employee.entity.model.Employee;
import com.demo.employee.entity.model.repo.EmployeeRepo;
import com.demo.employee.service.IEmployeeDataService;

@Component
public class EmployeeDataService implements IEmployeeDataService {
	
	@Autowired
	EmployeeRepo employeeRepo;

	public Employee createEmployee(Employee data) {
		Employee employee = employeeRepo.saveAndFlush(data);
		return employee;
	}
	
	public Employee getEmployeeById(int empId) {
		return employeeRepo.findByEmployeeId(empId);
	}
	
	public List<Employee> getAllActiveEmployees() {
		return employeeRepo.findAll();
	}
	
	public Employee updateEmployee(Employee data) {
		Employee employee = employeeRepo.saveAndFlush(data);
		return employee;
	}
	
	public void deleteEmployee(int employeeId) {
		Employee employee = employeeRepo.findByEmployeeId(employeeId);
		employeeRepo.delete(employee);
	}
	
}
