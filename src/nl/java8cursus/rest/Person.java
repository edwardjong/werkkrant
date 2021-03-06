package nl.java8cursus.rest;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String firstName;
	private String lastName;
	private String beroep;
	private String opleiding;
	private String ervaring;
	private String werkervaring;
	private String profiel;
	private String plaatje;
	private String cv;
	private Boolean active = Boolean.TRUE;

	public Person()
	{
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

	public String getPlaatje()
	{
		return plaatje;
	}

	public void setPlaatje(String plaatje)
	{
		this.plaatje = plaatje;
	}

	public String getBeroep()
	{
		return beroep;
	}

	public void setBeroep(String beroep)
	{
		this.beroep = beroep;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getOpleiding()
	{
		return opleiding;
	}

	public void setOpleiding(String opleiding)
	{
		this.opleiding = opleiding;
	}

	public String getErvaring()
	{
		return ervaring;
	}

	public void setErvaring(String ervaring)
	{
		this.ervaring = ervaring;
	}

	public String getWerkervaring()
	{
		return werkervaring;
	}

	public void setWerkervaring(String werkervaring)
	{
		this.werkervaring = werkervaring;
	}

	public String getProfiel()
	{
		return profiel;
	}

	public void setProfiel(String profiel)
	{
		this.profiel = profiel;
	}

	public String getCv()
	{
		return cv;
	}

	public void setCv(String cv)
	{
		this.cv = cv;
	}
	
	public boolean getActive()
	{
		return active;
	}

	public void setActive(boolean active)
	{
		this.active = active;
	}
}
