package app;

import model.Person;

public class App
{
	
	public static void main(String[] args)
	{
		Person verner = new Person("Verner", "Male", "1934-10-08 20:01:01");
		Person john = new Person("John", "Male", "1952-05-01 10:01:05");
		Person gerda = new Person("Gerda", "Female", "1952-04-21 17:12:01");
		Person henrik = new Person("Henrik", "Male", "1986-12-08 00:00:01");
		
		verner.addChild(john);
		henrik.addParent(john);
		gerda.addChild(henrik);
		
		verner.setDeath("2011-03-01 23:01:35");
	}
	
}
