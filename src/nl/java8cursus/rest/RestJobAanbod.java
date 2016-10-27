package nl.java8cursus.rest;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class RestJobAanbod implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private String skills;
	private String opleiding;
	private String ervaring;
	private String werkervaring;
	private String profiel;
	private String plaatje;
	private String cv;



	public RestJobAanbod(int id, String aFirstName, String aLastName, String aPlaatje, String aSkills) {
		setId(id);
			setFirstName(aFirstName);
			setLastName(aLastName);
			setPlaatje(aPlaatje);
			setSkills(aSkills);
		}
    
	public RestJobAanbod() {}
    
	public String getFirstName()
	{
		return firstName;
	}

	public String getFirstName1(int indexRestJobAanbodObject)
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getPlaatje()
	{
		return plaatje;
	}

	public void setPlaatje(String plaatje)
	{
		this.plaatje = plaatje;
	}

	public String getSkills()
	{
		return skills;
	}

	public void setSkills(String skills)
	{
		this.skills = skills;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
}
