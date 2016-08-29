package com.test.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeeDesk")
public class Employee {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "dept")
	private String dept;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_desk")
	private Desk simpleDeskName;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_man")
	private DeskManager manager;

	public Employee() {
	}

	public Employee(String firstName, String lastName, String dept) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setDept(dept);
	}

	public DeskManager getManager() {
		return manager;
	}

	public void setManager(DeskManager manager) {
		this.manager = manager;
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

	public Desk getSimpleDeskName() {
		return simpleDeskName;
	}

	public void setSimpleDeskName(Desk simpleDeskName) {
		this.simpleDeskName = simpleDeskName;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("id= ").append(id).append(", ")
				.append("fn= ").append(firstName).append(", ").append("ln= ")
				.append(lastName).append(", ").append("dp= ").append(dept)
				.toString();
	}
}