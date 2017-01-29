package com.demo.employee.entity.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the projects database table.
 * 
 */
@Entity
@Table(name="projects")
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="project_id")
	private int projectId;

	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Date enddate;

	private BigInteger revenue;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startdate;

	//bi-directional many-to-one association to Org
	@ManyToOne
	@JoinColumn(name="org_id")
	private Org org;

	//bi-directional many-to-many association to Employee
	@ManyToMany
	@JoinTable(
		name="teams"
		, joinColumns={
			@JoinColumn(name="project_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="employee_id")
			}
		)
	private List<Employee> employees;

	public Project() {
	}

	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public BigInteger getRevenue() {
		return this.revenue;
	}

	public void setRevenue(BigInteger revenue) {
		this.revenue = revenue;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Org getOrg() {
		return this.org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}