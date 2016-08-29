package com.test.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dmanager")
public class DeskManager {

	@Id
	@GeneratedValue
	@Column(name = "dm_id")
	private int id;

	@OneToMany(mappedBy = "manager")
	private List<Employee> subalterns = new ArrayList<Employee>();

	@OneToOne(mappedBy = "deskManager")
	private Desk managerOf;

	@Column(name = "name")
	private String name;

	public DeskManager() {
	}

	public DeskManager(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Employee> getSubalterns() {
		return subalterns;
	}

	public void setSubalterns(List<Employee> subalterns) {
		this.subalterns = subalterns;
	}

	public void addSubalterns(Employee sub) {
		this.subalterns.add(sub);
	}

	public Desk getManagerOf() {
		return managerOf;
	}

	public void setManagerOf(Desk managerOf) {
		this.managerOf = managerOf;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("id = ").append(id).append(", ")
				.append("sub = ").append(subalterns.size()).toString();
	}
}
