package nl.java8cursus.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import nl.luminis.javatraining.pojo.Person;

@Path("/aanbod")
public class DataOphalen
{

	
/*	@GET
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
		personList.add(new RestJobAanbod("Theo",  "Pont", "Images/theo.png", "theo skills"));
		personList.add(new RestJobAanbod("Marco", "Wenneker","Images/marco.png", "theo skills"));
		personList.add(new RestJobAanbod("Tai", "Chun Lee","Images/tai.png", "theo skills"));
		personList.add(new RestJobAanbod("Geert", "Janssen","Images/geert.png", "theo skills"));
		personList.add(new RestJobAanbod("Joey", "Krijgsman","Images/joey.png", "theo skills"));
		personList.add(new RestJobAanbod("Erik", "Bouts","Images/erik.png", "theo skills"));
		personList.add(new RestJobAanbod("Ronald", "van den Berg","Images/ronald.png", "theo skills"));
		personList.add(new RestJobAanbod("Yvonne", "Olij-Kenyon","Images/yvonne.png", "theo skills"));
		personList.add(new RestJobAanbod("Edward", "Jong-A-Lock","Images/edward.png", "theo skills"));
		personList.add(new RestJobAanbod("Peter", "Davidse","Images/peter.png", "theo skills"));
		personList.add(new RestJobAanbod("Kees", "Roest","Images/kees.png", "theo skills"));
				
		return personList;

	}

}
