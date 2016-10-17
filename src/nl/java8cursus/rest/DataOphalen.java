package nl.java8cursus.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import nl.luminis.javatraining.pojo.Person;

@Path("/HelloWorld")
public class DataOphalen
{

/*	@GET
	@Path("/sayHello")
	public String sayHello()
	{
		return "<h1>Hello World</h1>";
	}

	@GET
	@Path("/person/1")
	@Produces(MediaType.APPLICATION_JSON)
	public RestJobAanbod getPerson()
	{
		return new RestJobAanbod("Donald", "Duck");
	} */

	@GET
	@Path("/person")
	@Produces(MediaType.APPLICATION_JSON)
	public List<RestJobAanbod> getPersons()
	{
		List<RestJobAanbod> personList = new ArrayList<>();
		personList.add(new RestJobAanbod("Theo",  "Pont")); 
		personList.add(new RestJobAanbod("Marco", "Wenneker"));
		personList.add(new RestJobAanbod("Tai", "Chun Lee"));
		personList.add(new RestJobAanbod("Geert", "Janssen"));
		personList.add(new RestJobAanbod("Joey", "Krijgsman"));
		personList.add(new RestJobAanbod("Erik", "Bouts"));
		personList.add(new RestJobAanbod("Ronald", "van den Berg"));
		personList.add(new RestJobAanbod("Yvonne", "Olij-Kenyon"));
		personList.add(new RestJobAanbod("Edward", "Jong-A-Lock"));
		personList.add(new RestJobAanbod("Peter", "Davidse"));
		return personList;
	}
}
