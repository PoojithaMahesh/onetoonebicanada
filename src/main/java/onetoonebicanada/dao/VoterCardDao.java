package onetoonebicanada.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoonebicanada.dto.Person;
import onetoonebicanada.dto.VoterCard;

public class VoterCardDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	public void updateVoterCard(int id,VoterCard card) {
		EntityManager entityManager=getEntityManager();
	    VoterCard dbCard=entityManager.find(VoterCard.class, id);
	    if(dbCard!=null) {
	    	EntityTransaction entityTransaction=entityManager.getTransaction();
	    	entityTransaction.begin();
	    	
	    	card.setId(id);
	    	card.setPerson(dbCard.getPerson());
	    	
	    	entityManager.merge(card);
	    	entityTransaction.commit();
	    }else {
	    	System.out.println("Sorry id is not present");
	    }
	}
	
	public void findVoterCard(int id) {
		EntityManager entityManager=getEntityManager();
	    VoterCard dbCard=entityManager.find(VoterCard.class, id);
	    if(dbCard!=null) {
	    	System.out.println(dbCard);
	    }else {
	    	System.out.println("Sorry id is not present");
	    }
	}
	
	public void deleteVoterCard(int id) {
		EntityManager entityManager=getEntityManager();
	    VoterCard dbCard=entityManager.find(VoterCard.class, id);
	    if(dbCard!=null) {
	    	EntityTransaction entityTransaction=entityManager.getTransaction();
	    	entityTransaction.begin();
	    	
	    	Person person=dbCard.getPerson();
	    	person.setCard(null);
	    	
	    	entityManager.remove(dbCard);
	    	entityTransaction.commit();
	    }else {
	    	System.out.println("Sorry id is not present");
	    }
	}
	
	
	
	
	
	
}
