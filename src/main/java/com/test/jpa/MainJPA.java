package com.test.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.test.jpa.entity.Address;
import com.test.jpa.entity.Employee;

public class MainJPA {
	private static EntityManager em;

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("EmployeeService");
		em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(getEmployee());
//		em.persist(getAddress());
		em.getTransaction().commit();
	}

	private static Object getEmployee() {
		final Employee e = new Employee("marius", "cocoi", "maintanance");
		e.addAddress(new Address("beclean", 9));
		e.addAddress(new Address("cluj", 5));
		return e;
	}

	static Object getAddress() {
		final Employee e = new Employee("sorin", "cocoi", "java");
		
		Address adr = new Address("bec", 99);
		adr.setEmployee(e);
		
		return adr;
	}
}
