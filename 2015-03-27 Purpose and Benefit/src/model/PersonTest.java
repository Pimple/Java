package model;

import static org.junit.Assert.*;

import java.time.format.DateTimeFormatter;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonTest
{
	private Person verner;
	private Person john;
	private Person gerda;
	private Person henrik;
	
	@Before
	public void setUp() throws Exception
	{
		verner = new Person("Verner", "Male", "1934-10-08 20:01:01");
		john = new Person("John", "Male", "1952-05-01 10:01:05");
		gerda = new Person("Gerda", "Female", "1952-04-21 17:12:01");
		henrik = new Person("Henrik", "Male", "1986-12-08 00:00:01");
	}
	
	@Test
	public void testAddChild()
	{
		verner.addChild(john);
		assert verner.getChildren().contains(john);
		assert john.getParents().contains(verner);
		gerda.addChild(henrik);
		assert gerda.getChildren().contains(henrik);
		assert henrik.getParents().contains(gerda);
	}
	
	@Test
	public void testAddParent()
	{
		henrik.addParent(john);
		assert john.getChildren().contains(henrik);
		assert henrik.getParents().contains(john);
	}
	
	@Test
	public void testSetDeath()
	{
		verner.setDeath("2011-03-01 23:01:35");
		assert verner.isDead();
	}
	
	@Test(expected=AssertionError.class)
	public void testSetWrongDeath()
	{
		verner.setDeath("1910-03-01 23:01:35");
		assert verner.isDead();
	}
}
