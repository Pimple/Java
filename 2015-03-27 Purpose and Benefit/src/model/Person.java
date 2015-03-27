package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class Person
{
	private String name, sex;
	private LocalDateTime birth, death;
	private Set<Person> parents, children;
	private DateTimeFormatter datoformat;
	
	/**
	 * Instantiates new Person with name, sex and date and time of birth
	 * @param newName
	 * @param sex
	 * @param birthdate
	 */
	public Person(String newName, String sex, String birthdate)
	{
		datoformat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		this.name = newName;
		this.sex = sex;
		this.birth = LocalDateTime.parse(birthdate, datoformat);
		this.parents = new HashSet<>();
		this.children = new HashSet<>();
	}
	
	public String getName()
	{
		return name;
	}
	
	/**
	 * Name has to be at least 2 characters long
	 * @return
	 */
	public void setName(String name)
	{
		assert objectInvariant();
		assert name.length() >= 2;
		this.name = name;
		assert this.name != null;
		assert objectInvariant();
	}
	
	public String getSex()
	{
		return sex;
	}
	
	/**
	 * Has to be either "male" or "female", case insensitive
	 * @param sex
	 */
	public void setSex(String sex)
	{
		assert objectInvariant();
		assert sex.toLowerCase().equals("male") || sex.toLowerCase().equals("female");
		this.sex = sex.toLowerCase();
		assert objectInvariant();
	}
	
	public LocalDateTime getBirth()
	{
		return birth;
	}
	
	/**
	 * If death is set, birth must be before death
	 * @param birth
	 */
	public void setBirth(String birth)
	{
		assert objectInvariant();
		this.birth = LocalDateTime.parse(birth, datoformat);
		assert objectInvariant();
	}
	
	public LocalDateTime getDeath()
	{
		return death;
	}
	
	/**
	 * Death must be after birth
	 * @param death
	 */
	public void setDeath(String death)
	{
		assert objectInvariant();
		this.death = LocalDateTime.parse(death, datoformat);
		assert objectInvariant();
	}
	
	public Set<Person> getParents()
	{
		return parents;
	}
	
	/**
	 * Each person has at maximum two parents
	 * @param newParent
	 */
	public void addParent(Person newParent)
	{
		assert objectInvariant();
		if (!this.parents.contains(newParent))
		{
			this.parents.add(newParent);
			newParent.addChild(this);
		}
		assert objectInvariant();
	}
	
	public void removeParent(Person parent)
	{
		assert objectInvariant();
		this.parents.remove(parent);
		parent.removeChild(this);
		assert objectInvariant();
	}

	public Set<Person> getChildren()
	{
		return children;
	}
	
	public void addChild(Person newChild)
	{
		assert objectInvariant();
		if (!this.children.contains(newChild))
		{
			this.children.add(newChild);
			newChild.addParent(this);
		}
		assert objectInvariant();
	}
	
	public void removeChild(Person child)
	{
		assert objectInvariant();
		this.children.remove(child);
		child.removeParent(this);
		assert objectInvariant();
	}

	public boolean isDead()
	{
		return this.death != null;
	}
	
	/**
	 * @return True if everything is OK
	 */
	public boolean objectInvariant()
	{
		if (this.name == null || this.name.length() < 2)
			return false;
		
		if (this.birth == null)
			return false;
		
		if (this.death != null
			&& this.death.compareTo(this.birth) <= 0)
			return false;
			
		return true;
	}
}
