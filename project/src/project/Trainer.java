package project;

public class Trainer extends Person{

	
	private int TrainerID ;
	private int ExperienceYears ;
	

	public Trainer(String name, int age, char gender, int trainerID, int experience) {
		super(name, age, gender);
		TrainerID = trainerID;
		ExperienceYears = experience;
	}

	public void Print() {
			
		System.out.println("Trainer Name: "+ Name);
		System.out.println("Trainer Age: "+ Age);
		System.out.println("Trainer Gender: "+ Gender);
		System.out.println("Trainer ID: "+ TrainerID);
		System.out.println("Trainer Experience: "+ ExperienceYears);
		
	}

	public int getTrainerID() {
		return TrainerID;
	}

	public int getExperienceYears() {
		return ExperienceYears;
	}
	

}
