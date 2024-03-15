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
			System.out.println("3. Search member");

			System.out.println("4. Add Trainer ");
			System.out.println("5. Remove Trainer ");
			System.out.println("6. Search Trainer");

			System.out.println("7. Add Employee ");
			System.out.println("8. Remove Employee");
			System.out.println("9. Search Employee");

			System.out.println("10. Add Equipment");
			System.out.println("11. Remove Equipment") ; 
			System.out.println("12. Search Equipment") ; 

			System.out.println("13. Display All Members Information");
			System.out.println("14. Display All Trainers Information");
			System.out.println("15. Display All Employees Information");
			System.out.println("16. Display All Gym Information") ; 
			
			System.out.println("17. Exit") ; 
	
						
			System.out.print("your choice is : ");
			choice = input.nextInt() ;
			
			
			switch(choice) {
			
			case 1: 
				System.out.println("------------ Add member ------------");
				System.out.println("**Membership is restricted to females aged 16 years and older**");
				System.out.print("Enter member's Name: ");
				String name = input.next() ;
				System.out.print("Enter member's Age: ");
				int age = input.nextInt();
				System.out.print("Enter member's Gender: ");
				char gender = input.next().charAt(0);
				System.out.print("Enter member's membership Type 'G' for gold or 'S' for silver: ");
				char membershipType = input.next().charAt(0);
				input.nextLine();
				System.out.print("Enter member's weight goal: ");
				String Goal = input.nextLine() ;
				System.out.print("Enter member's ID: ");
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
				System.out.print("Enter member's ID: ");
				int Id = input.nextInt();
				if ( FitnessTime.removePerson(Id) )
					System.out.println("Member is Successfully removed");
				else
					System.out.println("Failed to remove Member, No member with ID: "+Id);
				System.out.println("----------------------------------------");
				break ;
				
			case 3:
				System.out.println("------------ Search member ------------");
				System.out.print("Enter Member's ID: ");
				int searchMemberID = input.nextInt();
				if ( FitnessTime.searchPerson(searchMemberID) == -1 )
					System.out.println("No Member with ID: "+searchMemberID) ; 
				else {
					Person[] Peoplelist = FitnessTime.getPeopleList() ;
					System.out.println("Found Member with ID:"+ searchMemberID) ; 
					System.out.println("-------- Member INFO -----------") ; 
					Peoplelist[FitnessTime.searchPerson(searchMemberID)].Print(); 	
				}
				break ;

			case 4: 
				
				System.out.println("------------ Add trainer ------------");
				System.out.println("**Trainer have to be 23 years old or older with two or more years of experience**");
				System.out.print("Enter Trainer's Name: ");
				String TrainerName = input.next() ;
				System.out.print("Enter Trainer's Age: ");
				int TrainerAge = input.nextInt();
				System.out.print("Enter Trainer's Gender: ");
				char TrainerGender = input.next().charAt(0);
				System.out.print("Enter Trainer's ID: ");
				int TrainerID = input.nextInt(); 
				System.out.print("Enter Trainer's Experience Years: ");
				int ExperienceYears = input.nextInt() ; 
				Trainer newTrainer = new Trainer(TrainerName,TrainerAge,TrainerGender,TrainerID ,ExperienceYears);
				if ( FitnessTime.addPerson(newTrainer) )
					System.out.println("Trainer is successfully added.");
				else
					System.out.println("Failed to add Trainer, Please check Trainer information.");
				System.out.println("---------------------------------");
				break; 
				
			case 5: 
				System.out.println("------------ Remove Trainer ------------");
				System.out.print("Enter Trainer's ID: ");
				int TrainerId= input.nextInt();
				if ( FitnessTime.removePerson(TrainerId) )
					System.out.println("Trainer is Successfully removed");
				else
					System.out.println("Failed to remove Trainer, No Trainer with "+TrainerId+" ID");
				System.out.println("----------------------------------------");
				break ;	

				
			case 6:
				System.out.println("------------ Search Trainer ------------");
				System.out.print("Enter Trainer's ID: ");
				int searchTrainerID = input.nextInt();
				if ( FitnessTime.searchPerson(searchTrainerID) == -1 )
					System.out.println("No Trainer with ID: "+searchTrainerID) ; 
				else {
					Person[] peoplelist = FitnessTime.getPeopleList() ;
					System.out.println("Found Trainer with ID: " + searchTrainerID) ; 
					System.out.println("-------- Trainer INFO -----------") ; 
					peoplelist[FitnessTime.searchPerson(searchTrainerID)].Print(); 	
				}
				break ;
			
             case 7: 
				
				System.out.println("------------ Add Employee ------------");
				System.out.println("**Employee have to be 21 years old or more**");
				System.out.print("Enter Employee's Name: ");
				String EmployeeName= input.next() ;
				System.out.print("Enter Employee's Age: ");
				int EmployeeAge = input.nextInt();
				System.out.print("Enter Employee's Gender: ");
				char EmployeeGender = input.next().charAt(0);
				System.out.print("Enter Employee's ID: ");
				int EmployeeID= input.nextInt(); 
				System.out.print("Enter Employee's Work Hours: ");
				int workHours = input.nextInt() ; 
				Employee newEmployee = new Employee(EmployeeName,EmployeeAge,EmployeeGender,workHours,EmployeeID);
				if ( FitnessTime.addPerson(newEmployee ) )
					System.out.println("Employee is successfully added.");
				else
					System.out.println("Failed to add Employee, Please check Employee information.");
				System.out.println("---------------------------------");
				break; 
				
			case 8: 
				System.out.println("------------ Remove Employee ------------");
				System.out.print("Enter Employee's ID: ");
				int EmployeeId = input.nextInt(); 
				if ( FitnessTime.removePerson(EmployeeId) )
					System.out.println("Employee is Successfully removed");
				else
					System.out.println("Failed to remove Employee, No Employee with "+EmployeeId+" ID");
				System.out.println("----------------------------------------");
				break ;
			
			case 9:
				System.out.println("------------ Search Employee ------------");
				System.out.print("Enter Employee's ID: ");
				int searchEmployeeID = input.nextInt();
				if ( FitnessTime.searchPerson(searchEmployeeID) == -1 )
					System.out.println("No employee with ID: "+searchEmployeeID) ; 
				else {
					Person[] peopleList = FitnessTime.getPeopleList() ;
					System.out.println("Found Employee with ID: "+ searchEmployeeID) ; 
					System.out.println("-------- Employee INFO -----------") ; 
					peopleList[FitnessTime.searchPerson(searchEmployeeID)].Print(); 	
				}
				break ;
				
				
			case 10: 
				System.out.println("------------ Add Equipment ------------");
				System.out.print("Enter equipment name: " ) ;
				String EquipmentName = input.next(); 
				System.out.print("Enter equipment ID: " ) ;
				int EquipmentID = input.nextInt(); 
				System.out.print("Enter equipment Type: " ) ;
				String EquipmentType = input.next(); 
				System.out.print("Enter equipment Quantity: " ) ;
				int EquipmentQuantity = input.nextInt(); 
				Equipment newEquipment = new Equipment(EquipmentName , EquipmentID, EquipmentType , EquipmentQuantity) ; 
				if(FitnessTime.addEquipment(newEquipment))
				System.out.println("Equipment is successfully added.");
				else
					System.out.println("Failed to add Equipment, there is no empty space.");
				System.out.println("---------------------------------");
				break; 
				
			case 11:
				System.out.println("------------ Remove Equipment ------------");
				System.out.print("Enter Equipment ID: ");
				int EquipmentId= input.nextInt();
				if ( FitnessTime.removeEquipment(EquipmentId) )
					System.out.println("Equipment is Successfully removed");
				else
					System.out.println("Failed to remove Equipment, No Equipment with ID: "+EquipmentId);
				System.out.println("----------------------------------------");
				break ;	

			case 12: 
				System.out.println("------------ Search Equipment ------------");
				System.out.println("Choose search option");
				System.out.print("Enter 'T' to search by type or 'N' to search by name: "); 
				char searchoption = input.next().charAt(0);
				switch(searchoption) {
				case 't': case 'T':
					System.out.print("Enter Equipment Type: "); 
					String searchEquipmentType = input.next() ; 
					if(FitnessTime.searchEquipmentByType(searchEquipmentType) != null)
						System.out.println("Found the Equipment.") ; 
					else
						System.out.println("The equipment does not exist.") ; 
				break ;
				case 'n' : case 'N' :
					System.out.print("Enter Equipment name:"); 
					String searchEquipmentName = input.next() ; 
					if(FitnessTime.searchEquipmentByName(searchEquipmentName) != null)
						System.out.println("Found the Equipment.") ; 
					else 
						System.out.println("The equipment does not exist ") ; 
				break;
	
				}
				System.out.println("---------------------------------");
				break;
			
				
				
			case 13:
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
				
			case 14:
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
			
			case 15:
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
				
			case 16:
				FitnessTime.Display();
			
			
			
			}
			
			
			
			
			
			
		}while (choice != 17);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
