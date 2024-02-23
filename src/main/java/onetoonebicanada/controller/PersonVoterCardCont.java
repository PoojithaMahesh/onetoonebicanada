package onetoonebicanada.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoonebicanada.dao.PersonDao;
import onetoonebicanada.dao.VoterCardDao;
import onetoonebicanada.dto.Person;
import onetoonebicanada.dto.VoterCard;

public class PersonVoterCardCont {
public static void main(String[] args) {
	Person person=new Person();
	person.setId(2);
	person.setName("aryan");
    person.setAddress("canada");
    
    
    VoterCard card=new VoterCard();
    card.setId(200);
    card.setName("aryan");
    card.setAge(20);
    
    card.setPerson(person);
    person.setCard(card);
    
//    EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
//    EntityManager entityManager=entityManagerFactory.createEntityManager();
//    EntityTransaction entityTransaction=entityManager.getTransaction();
//    entityTransaction.begin();
//    
//    entityManager.persist(person);
//    entityManager.persist(card);
//    
//    entityTransaction.commit();

//    PersonDao dao=new PersonDao();
//    dao.deletePerson(1);
//    
    
    VoterCardDao cardDao=new VoterCardDao();
    cardDao.deleteVoterCard(200);
    
    
    
    
}
}
