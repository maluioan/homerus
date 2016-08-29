package com.test.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "desk")
public class Desk {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_desk")
	private int idDesk;
	
	@OneToOne(mappedBy = "simpleDeskName", cascade=CascadeType.ALL)
	private Employee employee;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="dm_id")
	private DeskManager deskManager;

	private String name;

	public DeskManager getDeskManager() {
		return deskManager;
	}

	public void setDeskManager(DeskManager deskManager) {
		this.deskManager = deskManager;
	}

	public int getIdDesk() {
		return idDesk;
	}

	public void setIdDesk(int idDesk) {
		this.idDesk = idDesk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return new StringBuilder()
		.append("id= ").append(idDesk).append(", ")
		.append("name= ").append(name)
		.toString();
	}
}
