package nl.java8cursus.rest;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//import nl.luminis.javatraining.pojo.Person;

@Stateless
public class PersonDAO {

	@PersistenceContext
	public EntityManager em;
	
	public void savePerson(RestJobAanbod person) {
		em.persist(person);
	}
	
	public List<RestJobAanbod> getPersonList()
	{
		List<RestJobAanbod> personList = em.createQuery(
	            "SELECT p FROM RestJobAanbod p", RestJobAanbod.class).getResultList();
		return personList;
	}
	
}