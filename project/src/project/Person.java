package project;

public abstract class Person {

	
	protected String Name ;
	protected int Age ;
	protected char Gender ;
	protected int ID ;
	
	
	public Person(String name, int age, char gender, int id) {
		Name = name;
		Age = age;
		Gender = gender;
		ID = id ;
	}


	public abstract void Print();


	public String getName() {
		return Name;
	}


	public int getAge() {
		return Age;
	}


	public char getGender() {
		return Gender;
	}


	public int getID() {
		return ID;
	}

	
}
