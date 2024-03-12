package project;
import java.util.Scanner ;

public class GymManagementSystem {

	public static void main(String[] args) {
		Scanner input = new Scanner ( System.in );
		
		Gym FitnessTime = new Gym("Fitness Time","Yasmeen, Riyadh", 500, 200);
		
		System.out.println("**************** Gym Management System ****************");
			System.out.println("Welcome to Gym Management System , what do you need for today? ( Enter your menu option )");
		
		int choice ;
		do {
			
			System.out.println("1. Add member");
			System.out.println("2. Remove member");
			System.out.println("3. Add Trainer ");
			System.out.println("4. Remove Trainer ");
			System.out.println("5. Add Employee ");
			System.out.println("6. Remove Employee");
			System.out.println("7. Add Equipment");
			System.out.println("8. Search Equipment") ; 
			System.out.println("9. Display All Members Information");
			System.out.println("10. Display All Trainers Information");
			System.out.println("11. Display All Employees Information");
			System.out.println("12. Display All Gym Information") ; 
			System.out.println("13. Exit") ; 
	
						
			System.out.print("your choice is : ");
			choice = input.nextInt() ;
			
			
			switch(choice) {
			
			case 1: 
				System.out.println("------------ Add member ------------");
				System.out.println("**Membership is restricted to females aged 16 years and older**");
				System.out.print("Enter member Name: ");
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
				System.out.print("Enter member ID: ");
				int Id = input.nextInt();
				if ( FitnessTime.removePerson(Id) )
					System.out.println("Member is Successfully removed");
				else
					System.out.println("Failed to remove Member, No member with "+Id+" ID");
				System.out.println("----------------------------------------");
				break ;

			case 3: 
				
				System.out.println("------------ Add trainer ------------");
				System.out.println("**Trainer have to be 23 years old or older with tow or more ywars of experience**");
				System.out.print("Enter Trainer Name: ");
				String nameT = input.next() ;
				System.out.print("Enter Trainer Age: ");
				int ageT = input.nextInt();
				System.out.print("Enter Trainer Gender: ");
				char genderT = input.next().charAt(0);
				System.out.print("Enter Trainer Id: ");
				int idT = input.nextInt(); 
				System.out.print("Enter Trainer Experience Years: ");
				int ExperienceYears = input.nextInt() ; 
				Trainer newTrainer = new Trainer(nameT,ageT,genderT,idT ,ExperienceYears);
				if ( FitnessTime.addPerson(newTrainer) )
					System.out.println("Trainer is successfully added.");
				else
					System.out.println("Failed to add Trainer, Please check Trainer information.");
				System.out.println("---------------------------------");
				break; 
				
			case 4: 
				System.out.println("------------ Remove Trainer ------------");
				System.out.print("Enter Trainer ID: ");
				int Idt= input.nextInt();
				if ( FitnessTime.removePerson(Idt) )
					System.out.println("Trainer is Successfully removed");
				else
					System.out.println("Failed to remove Trainer, No Trainer with "+Idt+" ID");
				System.out.println("----------------------------------------");
				break ;	
             case 5: 
				
				System.out.println("------------ Add Employee ------------");
				System.out.println("**Employee have to be 21 years old or more**");
				System.out.print("Enter Employee Name: ");
				String nameE= input.next() ;
				System.out.print("Enter Employee Age: ");
				int ageE = input.nextInt();
				System.out.print("Enter Employee Gender: ");
				char genderE = input.next().charAt(0);
				System.out.print("Enter Employee Id: ");
				int idE= input.nextInt(); 
				System.out.print("Enter Employee Work Hours: ");
				int workHours = input.nextInt() ; 
				Employee newEmployee = new Employee(nameE,ageE,genderE,workHours,idE);
				if ( FitnessTime.addPerson(newEmployee ) )
					System.out.println("Employee is successfully added.");
				else
					System.out.println("Failed to add Employee, Please check Employee information.");
				System.out.println("---------------------------------");
				break; 
				
			case 6: 
				System.out.println("------------ Remove Employee ------------");
				System.out.print("Enter Employee ID: ");
				int Ide = input.nextInt(); 
				if ( FitnessTime.removePerson(Ide) )
					System.out.println("Employee is Successfully removed");
				else
					System.out.println("Failed to remove Employee, No Employee with "+Ide+" ID");
				System.out.println("----------------------------------------");
				break ;
				
				
			
			case 7: 
				System.out.println("------------ Add Equipment ------------");
				System.out.print("Enter equipment name: " ) ;
				String nameEQ = input.next(); 
				System.out.print("Enter equipment Type: " ) ;
				String typeEQ = input.next(); 
				System.out.print("Enter equipment Quantity: " ) ;
				int quantity = input.nextInt(); 
				Equipment newEquipment = new Equipment(nameEQ , typeEQ , quantity) ; 
				if(FitnessTime.addEquipment(newEquipment))
				System.out.println("Equipment is successfully added.");
				else
					System.out.println("Failed to add Equipment, there is no emptay space.");
				System.out.println("---------------------------------");
				break; 
				
				

			case 8: 
				System.out.println("------------ Search Equipment ------------");
				System.out.println("Choose search option");
				System.out.print("Enter 'T' to search by type or 'N' to search by name: "); 
				char searchoption = input.next().charAt(0);
				switch(searchoption) {
				case 't': case 'T':
					System.out.print("Enter Equipment Type: "); 
					String EQType = input.next() ; 
					if(FitnessTime.searchEquipmentByType(EQType) != null)
						System.out.println("Found the Equipment.") ; 
					else
						System.out.println("The equipment does not exist.") ; 
				break ;
				case 'n' : case 'N' :
					System.out.print("Enter Equipment name:"); 
					String EQname = input.next() ; 
					if(FitnessTime.searchEquipmentByName(EQname) != null)
						System.out.println("Found the Equipment.") ; 
					else 
						System.out.println("The equipment does not exist ") ; 
				break;
	
				}
				System.out.println("---------------------------------");
				break;
					
			case 9:
				System.out.println("------------ All Employees Information ------------");
				System.out.println("------------ Number of Employees: "+FitnessTime.getNumOfEmployees()+" ------------");
				Person[] AllEmployees = FitnessTime.getEmployees() ;
				for ( int i = 0 ; i < AllEmployees.length ; i++ )
					if ( AllEmployees[i] != null ) {
						AllEmployees[i].Print();
						System.out.println("-----");
					}		
				System.out.println("---------------------------------");
				break ;
				
			case 10:
				System.out.println("------------ All Members Information ------------");
				System.out.println("------------ Number of Members: "+FitnessTime.getNumOfMembers()+" ------------");
				Person[] AllMembers = FitnessTime.getMembers() ;
				for ( int i = 0 ; i < AllMembers.length ; i++ )
					if ( AllMembers[i] != null ) {
						AllMembers[i].Print();
						System.out.println("-----");
					}		
				System.out.println("---------------------------------");
				break ;
			
			case 11:
				System.out.println("------------ All Trainers Information ------------");
				System.out.println("------------ Number of Trainers: "+FitnessTime.getNumOfTrainers()+" ------------");
				Person[] AllTrainers = FitnessTime.getTrainers() ;
				for ( int i = 0 ; i < AllTrainers.length ; i++ )
					if ( AllTrainers[i] != null ) {
						AllTrainers[i].Print();
						System.out.println("-----");
					}		
				System.out.println("---------------------------------");
				break ;
				
			case 12:
				FitnessTime.Display();
			
			
			
			}
			
			
			
			
			
			
		}while (choice != 13);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
