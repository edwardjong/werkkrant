package nl.java8cursus.rest;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.inject.Inject;


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

	
	@POST
	@Path("/person")
	@Consumes(MediaType.APPLICATION_JSON)
	public void savePerson(Person person)
	{
		personService.savePerson(person);
		System.out.println("Added a person with firstname " + person.getFirstName() + " and with lastname "
				+ person.getLastName());
	}
}
