package nl.java8cursus.rest;

import java.io.Serializable;

public class RestJobAanbod implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String plaatje;
	private String skills;

	public RestJobAanbod(String aFirstName, String aLastName, String aPlaatje, String aSkills) {
			setFirstName(aFirstName);
			setLastName(aLastName);
			setPlaatje(aPlaatje);
			setSkills(aSkills);
		}

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
}
