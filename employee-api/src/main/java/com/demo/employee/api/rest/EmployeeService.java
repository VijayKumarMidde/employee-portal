package com.demo.employee.api.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.employee.api.assembler.EmployeeAssembler;
import com.demo.employee.api.model.BaseResponse;
import com.demo.employee.api.model.EmployeeRequest;
import com.demo.employee.api.model.EmployeeResponse;
import com.demo.employee.entity.model.Employee;
import com.demo.employee.service.IEmployeeDataService;
import com.demo.employee.service.impl.EmployeeDataService;

@RestController
public class EmployeeService {

	private static final Logger logger = LoggerFactory
			.getLogger(EmployeeService.class);

	@Autowired
	private IEmployeeDataService employeeDataService;

	@Autowired
	private EmployeeAssembler employeeAssembler;
	
	@RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.PUT)
	public BaseResponse<Integer> updateEmployee(@PathVariable int employeeId,
			@RequestBody EmployeeRequest request) {
		BaseResponse<Integer> response = new BaseResponse<Integer>();
		Employee employee = employeeDataService.getEmployeeById(employeeId);
		employeeAssembler.updateEmployee(employee, request);
		employee = employeeDataService.updateEmployee(employee);
		response.setStatus("SUCCESS");
		response.setResult(employee.getEmployeeId());
		return response;
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public BaseResponse<Integer> createEmployee(@RequestBody EmployeeRequest request) {
		BaseResponse<Integer> response = new BaseResponse<Integer>();
		Employee employee = new Employee();
		employeeAssembler.updateEmployee(employee, request);
		employee = employeeDataService.createEmployee(employee);
		response.setStatus("SUCCESS");
		response.setResult(employee.getEmployeeId());
		return response;
	}

	@RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.GET)
	public BaseResponse<EmployeeResponse> getEmployee(
			@PathVariable int employeeId) {

		BaseResponse<EmployeeResponse> response = new BaseResponse<EmployeeResponse>();
		response.setStatus("SUCCESS");
		response.setResult(employeeAssembler
				.assembleEmployee(employeeDataService
						.getEmployeeById(employeeId)));
		return response;
	}

	@RequestMapping(value = "/employees/all", method = RequestMethod.GET)
	public BaseResponse<List<EmployeeResponse>> getAllActiveEmployees() {
		BaseResponse<List<EmployeeResponse>> response = new BaseResponse<List<EmployeeResponse>>();
		response.setResult(employeeAssembler
				.assembleEmployees(employeeDataService.getAllActiveEmployees()));
		response.setStatus("SUCCESS");
		return response;
	}
	
	@RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.DELETE)
	public BaseResponse<Integer> deleteEmployee(
			@PathVariable int employeeId) {

		BaseResponse<Integer> response = new BaseResponse<Integer>();
		employeeDataService.deleteEmployee(employeeId);
		response.setStatus("SUCCESS");
		response.setResult(-1);
		return response;
	}
}