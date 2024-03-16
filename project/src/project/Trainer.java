package project;

public class Trainer extends Person{

	
	private int ExperienceYears ;

	public Trainer(String name, int age, char gender,int id, int experience) {
		super(name, age, gender,id);
		ExperienceYears = experience;
		
	}

	public void Print() {
			
		System.out.println("Trainer's Name: "+ Name);
		System.out.println("Trainer's Age: "+ Age);
		System.out.println("Trainer's Gender: "+ Gender);
		System.out.println("Trainer's ID: "+ ID);
		System.out.println("Trainer's Experience: "+ ExperienceYears);
		System.out.println("Trainer's Salary: "+ calculateSalary());

		
	}
	
	public double calculateSalary() {
		if(ExperienceYears == 2) 
		return 6500 ; 
		else 
			if(ExperienceYears == 3)
			return 7000 ; 
			else
		if(ExperienceYears == 4)
			return 7500 ; 
		else
			if(ExperienceYears >=5 )
				return 8000 ; 
			else 
				return 0 ; 


} 


	public int getExperienceYears() {
		return ExperienceYears;
	}
	

}
