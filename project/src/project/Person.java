package project;

public abstract class Person {

	
	protected String Name ;
	protected int Age ;
	protected char Gender ;
	
	
	public Person(String name, int age, char gender) {
		Name = name;
		Age = age;
		Gender = gender;
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

	
}
