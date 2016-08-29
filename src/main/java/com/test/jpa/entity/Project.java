package com.test.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
// defaults to class name
public class Project {

	@Id
	@GeneratedValue
	@Column(name = "idProject")
	private int id;

	@Column(name = "name")
	// defaults to field name
	private String projectName;

	@ManyToMany(mappedBy = "projects", cascade = CascadeType.PERSIST)
	private List<Employee> employes = new ArrayList<Employee>();

	public Project() {
	}

	public Project(String string) {
		this.projectName = string;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Employee> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employee> employes) {
		this.employes = employes;
	}

	public void addEmployee(Employee e) {
		this.employes.add(e);
	}

}
