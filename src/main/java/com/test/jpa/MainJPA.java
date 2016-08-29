package com.test.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.test.jpa.entity.Employee;
import com.test.jpa.entity.Project;

public class MainJPA {
	private static EntityManager em;

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("EmployeeService");
		em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(getEmployee());
		em.getTransaction().commit();
	}

	static Employee getEmployee() {
		final Employee e = new Employee("sorin", "cocoi", "java");
		e.addProject(new Project("UAT"));
		e.addProject(new Project("Trimonstorious"));
		e.addProject(new Project("spring"));
		return e;
	}
}
