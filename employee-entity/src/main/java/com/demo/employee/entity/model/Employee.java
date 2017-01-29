package com.demo.employee.entity.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="employee_id")
	private int employeeId;

	@Column(name="department_id")
	private int departmentId;

	private int designation;

	private String email;

	private String name;

	private int salary;

	//bi-directional many-to-one association to Org
	@OneToMany(mappedBy="employee")
	private List<Org> orgs;

	//bi-directional many-to-many association to Project
	@ManyToMany(mappedBy="employees")
	private List<Project> projects;

	public Employee() {
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getDesignation() {
		return this.designation;
	}

	public void setDesignation(int designation) {
		this.designation = designation;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return this.salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public List<Org> getOrgs() {
		return this.orgs;
	}

	public void setOrgs(List<Org> orgs) {
		this.orgs = orgs;
	}

	public Org addOrg(Org org) {
		getOrgs().add(org);
		org.setEmployee(this);

		return org;
	}

	public Org removeOrg(Org org) {
		getOrgs().remove(org);
		org.setEmployee(null);

		return org;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}