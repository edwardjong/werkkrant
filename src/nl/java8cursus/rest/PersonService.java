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
	
	public void addPerson(RestJobAanbod person) {
		personDAO.savePerson(person);
	}
	
	public List<RestJobAanbod> getPersonList() {
		return personDAO.getPersonList();
	}
}