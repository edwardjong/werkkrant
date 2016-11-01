package nl.java8cursus.rest;

//import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
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
	public List<RestJobAanbod> getPersons()
	{
		List<RestJobAanbod> personList = personService.getPersonList();				
		return personList;
	}

/*	private List<RestJobAanbod> getPersonList()
	{

		
		List<RestJobAanbod> personList = em.createQuery(
	            "SELECT p FROM Person p").getResultList();
	//	List<RestJobAanbod> personList = new ArrayList<>();
		personList.add(new RestJobAanbod(1, "Theo",  "Pont", "Images/theo.png", "theo skills"));
		personList.add(new RestJobAanbod(2, "Marco", "Wenneker","Images/marco.png", "theo skills"));
		personList.add(new RestJobAanbod(3, "Tai", "Chun Lee","Images/tai.png", "theo skills"));
		personList.add(new RestJobAanbod(4,"Geert", "Janssen","Images/geert.png", "theo skills"));
		personList.add(new RestJobAanbod(5,"Joey", "Krijgsman","Images/joey.png", "theo skills"));
		personList.add(new RestJobAanbod(6,"Erik", "Bouts","Images/erik.png", "theo skills"));
		personList.add(new RestJobAanbod(7,"Ronald", "van den Berg","Images/ronald.png", "theo skills"));
		personList.add(new RestJobAanbod(8,"Yvonne", "Olij-Kenyon","Images/yvonne.png", "theo skills"));
		personList.add(new RestJobAanbod(9, "Edward", "Jong-A-Lock","Images/edward.png", "theo skills"));
		personList.add(new RestJobAanbod(10, "Peter", "Davidse","Images/peter.png", "theo skills"));
		personList.add(new RestJobAanbod(11, "Kees", "Roest","Images/kees.png", "theo skills"));
		return personList;
	}*/
	
	@GET
	@Path("/person/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public RestJobAanbod getOnePerson(@PathParam("id") int id)
	{
		List<RestJobAanbod> personList = personService.getPersonList();
		for (RestJobAanbod onePerson : personList)
			{ 
				if(onePerson.getId() == id) 
					{
						System.out.println("person with id " + id + " is requested from the server");
						return onePerson;
					}
			}
		return null;
	} 
}
