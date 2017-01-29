package com.demo.employee.api.model;

public class EmployeeResponse {
	private int employeeId;
	private String name;
	private String email;
	private int department;
	private int salary;
	private int designation;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int i) {
		this.salary = i;
	}

	public int getDesignation() {
		return designation;
	}

	public void setDesignation(int designation) {
		this.designation = designation;
	}
}
