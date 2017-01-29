package com.demo.employee.api.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.employee.api.model.EmployeeRequest;
import com.demo.employee.api.model.EmployeeResponse;
import com.demo.employee.entity.model.Employee;

@Component
public class EmployeeAssembler {

	public List<EmployeeResponse> assembleEmployees(List<Employee> employeeList) {
		List<EmployeeResponse> result = new ArrayList<EmployeeResponse>();
		for (Employee employee : employeeList) {
			result.add(assembleEmployee(employee));
		}
		return result;
	}

	public EmployeeResponse assembleEmployee(Employee employee) {
		EmployeeResponse result = new EmployeeResponse();
		result.setEmployeeId(employee.getEmployeeId());
		result.setName(employee.getName());
		result.setDepartment(employee.getDepartmentId());
		result.setDesignation(employee.getDesignation());
		result.setEmail(employee.getEmail());
		result.setSalary(employee.getSalary());
		return result;
	}
	
	public void updateEmployee(Employee employee, EmployeeRequest request) {
		employee.setName(request.getName());
		employee.setEmail(request.getEmail());
		employee.setDepartmentId(request.getDepartment());
		employee.setDesignation(request.getDesignation());
		employee.setSalary(request.getSalary());
	}
}
