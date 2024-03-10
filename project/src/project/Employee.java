package project;

	public class Employee extends Person {
	private int workingHours ; 

	public Employee(String name, int age, char gender , int hours , int id) {
			super( name, age,  gender, id) ;
			workingHours = hours; 
			
	}
	public double calculateSalary() { 
		return workingHours*600 ; 


	}
	public void Print()  {
		
		System.out.println("Member Name: "+ Name);
		System.out.println("Member Age: "+ Age);
		System.out.println("Member Gender: "+ Gender);
		System.out.println("Working Hours: "+ workingHours);
	}
	public int getworkinHoures() 
	{
		return workingHours ; 
	}
	
	}
	
	
	
	
	
	
