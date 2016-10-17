package nl.java8cursus.rest;

import java.io.Serializable;

public class RestJobAanbod implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;

	public RestJobAanbod(String aFirstName, String aLastName) {
			setFirstName(aFirstName);
			setLastName(aLastName);
		}

	public String getFirstName()
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
}
