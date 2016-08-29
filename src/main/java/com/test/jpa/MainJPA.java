package com.test.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.test.jpa.entity.Desk;
import com.test.jpa.entity.DeskManager;
import com.test.jpa.entity.Employee;

@SuppressWarnings({"rawtypes"})
public class MainJPA {
	private static EntityManager em;

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("EmployeeService");
		em = emf.createEntityManager();

// save  employee
		em.getTransaction().begin();
		em.persist(getEmployee());
		em.getTransaction().commit();
		Query q = em.createQuery("select e from Employee e");
		showEntities(q.getResultList());

// save desk
//		em.getTransaction().begin();
//		em.persist(getDesk());
//		em.getTransaction().commit();
//		q = em.createQuery("select d from Desk d");
//		showEntities(q.getResultList());
	}

	private static Employee getEmployee() {
		final Employee e = new Employee("marius", "cocoi", "maintanance");
		e.setSimpleDeskName((Desk)getDesk());
		e.setManager(new DeskManager("the manager"));
		return e;
	}

	static Desk getDesk() {
		final Desk desk = new Desk();
		desk.setDeskManager(getDeskManager());
		desk.setName("artificial inteligence");
		return desk;
	}

	static DeskManager getDeskManager() {
		final DeskManager dm = new DeskManager();
		dm.addSubalterns(new Employee("gicutu", "alubel", "oi"));
		dm.addSubalterns(new Employee("pastrama", "giucubete", "lacate"));
		return dm;
	}

	static void showEntities(List ent) {
		for (Object e :ent) {
			System.out.println(e);
		}
	}
}
