package project;
import java.util.Scanner ;

public class GymManagementSystem {

	public static void main(String[] args) {
		Scanner input = new Scanner ( System.in );
		
		Gym FitnessTime = new Gym("Fitness Time","Yasmeen, Riyadh", 1500, 500);
		
		
		int choice ;
		do {
			
			System.out.println("**************** Gym Management System ****************");
			System.out.println("Welcome to Gym Management System , what do you need for today? ( Enter your menu option )");
			System.out.println("1. Add member");
			System.out.println("2. Remove member");
			// ****************************
			
			System.out.print("your choice is : ");
			choice = input.nextInt() ;
			
			
			switch(choice) {
			
			case 1: 
				System.out.println("------------ Add member ------------");
				System.out.println("**Members must be females with an age of 16 or more**");
				System.out.print("Please Enter member Name: ");
				String name = input.next() ;
				System.out.print("Enter member Age: ");
				int age = input.nextInt();
				System.out.print("Enter member Gender: ");
				char gender = input.next().charAt(0);
				System.out.print("Enter member membershipType: ");
				char membershipType = input.next().charAt(0);
				input.nextLine();
				System.out.print("Enter member goal: ");
				String Goal = input.nextLine() ;
				System.out.print("Enter member ID: ");
				int id = input.nextInt();
				Member newMember = new Member(name,age,gender,id,membershipType,Goal);
				if ( FitnessTime.addPerson(newMember) )
					System.out.println("Member is successfully added.");
				else
					System.out.println("Failed to add Member, Please check member information.");
				System.out.println("---------------------------------");
				break ;
			case 2:
				System.out.println("------------ Remove member ------------");
				System.out.print("Please Enter member ID: ");
				int Id = input.nextInt();
				if ( FitnessTime.removePerson(Id) )
					System.out.println("Member is Successfully removed");
				else
					System.out.println("Failed to remove Member, No member with "+Id+" ID");
				System.out.println("---------------------------------");
				break ;

			
			
			
			
			
			}
			
			
			
			
			
			
		}while (choice != 5);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
