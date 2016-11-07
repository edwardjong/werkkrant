package nl.java8cursus.rest;

//import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
//import javax.transaction.Transactional;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.inject.Inject;
//import javax.persistence.EntityManager;
//import nl.luminis.javatraining.pojo.Person;

@Path("/aanbod")
public class DataOphalen
{

	@Inject
	private PersonService personService;

	@GET
	@Path("/person")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getPersons()
	{
		List<Person> personList = personService.getPersonList();
		return personList;
	}

	@GET
	@Path("/person/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getOnePerson(@PathParam("id") int id)
	{
		List<Person> personList = personService.getPersonList();
		for (Person onePerson : personList)
		{
			if (onePerson.getId() == id)
			{
				System.out.println("person with id " + id + " is requested from the server");
				return onePerson;
			}
		}
		return null;
	}

/*	@POST
	@Path("/person/1")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addPerson(Person person)
	{
		personService.addPerson(person);
		System.out.println("Added a person with firstname " + person.getFirstName() + " and with lastname "
				+ person.getLastName());
	}*/
	
	@POST
	@Path("/person/1")
	@Consumes(MediaType.APPLICATION_JSON)
//	@Transactional 
	public void savePerson(Person person)
	{
		personService.savePerson(person);
		System.out.println("Added a person with firstname " + person.getFirstName() + " and with lastname "
				+ person.getLastName());
	}
}
