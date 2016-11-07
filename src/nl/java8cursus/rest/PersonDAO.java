package nl.java8cursus.rest;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonDAO {

	@PersistenceContext
	public EntityManager em;
	
	public void savePerson(Person person) {
		em.persist(person);
	}
	
	public List<Person> getPersonList()
	{
		List<Person> personList = em.createQuery(
	            "SELECT p FROM Person p", Person.class).getResultList();
		return personList;
	}
	
}