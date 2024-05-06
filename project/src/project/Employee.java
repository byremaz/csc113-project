package project;

public class Employee extends Person {
private int workHours ; 

public Employee(String name, int age, char gender , int hours , int id) {
		super( name, age,  gender, id) ;
		workHours = hours; 
		
}
public double calculateSalary() { 
	return workHours*600 ; 


}
public void Print()  {
	
	System.out.println("Employee's Name: "+ Name);
	System.out.println("Employee's Age: "+ Age);
	System.out.println("Employee's Gender: "+ Gender);
	System.out.println("Working Hours: "+ workHours);
	System.out.println("Employee Salary: "+ calculateSalary());
  }	
  public int getworkHours() 
{
	return workHours ; 
}

}


