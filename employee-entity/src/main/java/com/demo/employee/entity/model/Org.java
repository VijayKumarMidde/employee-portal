package com.demo.employee.entity.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the orgs database table.
 * 
 */
@Entity
@Table(name="orgs")
@NamedQuery(name="Org.findAll", query="SELECT o FROM Org o")
public class Org implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="org_id")
	private int orgId;

	private String name;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="manager_id")
	private Employee employee;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="org")
	private List<Project> projects;

	public Org() {
	}

	public int getOrgId() {
		return this.orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setOrg(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setOrg(null);

		return project;
	}

}