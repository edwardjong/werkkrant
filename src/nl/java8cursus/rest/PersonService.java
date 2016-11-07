package nl.java8cursus.rest;


import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

//import nl.luminis.javatraining.dao.PersonDAO;
//import nl.luminis.javatraining.pojo.Person;

@Stateless
@Transactional
public class PersonService {

	@Inject
	private PersonDAO personDAO;
	
	public void savePerson(Person person) {
		personDAO.savePerson(person);
	}
	
	public List<Person> getPersonList() {
		return personDAO.getPersonList();
	}
}