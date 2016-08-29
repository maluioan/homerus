package com.test.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Column(name = "fistName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "dept")
    private String dept;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
    		name="employee_project", 
    		joinColumns = @JoinColumn(name = "idangajat"), 
    		inverseJoinColumns = @JoinColumn(name = "idproiect")
    )
    private List<Project> projects = new ArrayList<Project>();

    public Employee(){
    }

    public Employee(String firstName, String lastName, String dept){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setDept(dept);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public void addProject(Project project) {
		this.projects.add(project);
	}

}
