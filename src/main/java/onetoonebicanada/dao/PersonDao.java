package onetoonebicanada.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoonebicanada.dto.Person;

public class PersonDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}

	public void updatePerson(int id, Person person) {
		EntityManager entityManager = getEntityManager();
		Person dbPerson = entityManager.find(Person.class, id);
		if (dbPerson != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();

			person.setId(id);
			person.setCard(dbPerson.getCard());

			entityManager.merge(person);
			entityTransaction.commit();
		} else {
			System.out.println("Sorry id is not present");
		}
	}
	public void findPerson(int id) {
		EntityManager entityManager = getEntityManager();
		Person dbPerson = entityManager.find(Person.class, id);
		if (dbPerson != null) {
			System.out.println("yes fetched");
		} else {
			System.out.println("Sorry id is not present");
		}
	}
	
	public void deletePerson(int id) {
		EntityManager entityManager = getEntityManager();
		Person dbPerson = entityManager.find(Person.class, id);
		if (dbPerson != null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbPerson);
			entityTransaction.commit();
		} else {
			System.out.println("Sorry id is not present");
		}
	}
	
	
	
	
	
	
	
}
