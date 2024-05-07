package project;
import java.util.Scanner ;
import java.io.*;

public class GymManagementSystem {

	public static void main(String[] args) throws InvalidIdException {
		Scanner input = new Scanner ( System.in );
		
		Gym FitnessTime = loadGymInfo();
        if (FitnessTime == null) {
            FitnessTime = new Gym("Fitness Time", "Yasmeen, Riyadh", 500, 200);		
		Employee empNorah=new Employee("Norah",23,'f',6,1122334400);
		Employee empLama=new Employee("Lama",28,'f',8,1123458900);
		Employee empSara=new Employee("Sara",24,'f',7,1254768000);
		
		FitnessTime.addPerson(empNorah);
		FitnessTime.addPerson(empLama);
		FitnessTime.addPerson(empSara);
		
		Equipment treadmill=new Equipment("treadmill", 1, "cardio");
		Equipment elliptical=new Equipment("elliptical", 2, "cardio");
		Equipment latPulldown=new Equipment("lat pulldown", 3, "strength");

		FitnessTime.addEquipment(treadmill);
		FitnessTime.addEquipment(elliptical);
		FitnessTime.addEquipment(latPulldown);
		}

		
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
			boolean EnterWhileLoop = true ;
			
			switch(choice) {
			
			case 1: 
				System.out.println("------------ Add member ------------");
				System.out.println("**Membership is restricted to females aged 16 years and older**");
				System.out.print("Enter member Name: ");
				String name = input.next() ;
				
				
				int age = 0 ;
				while(EnterWhileLoop)
				{
				try{
				System.out.print("Enter member's Age: ");
				age = input.nextInt();
				if ( age < 16 )
                    throw new InvalidAgeException("Age must be 16 years and older");
				EnterWhileLoop = false;
				}
				catch(InvalidAgeException ex )
				{
					System.out.println(ex);
				}
				}
				
				EnterWhileLoop = true ;
				char gender = 0; 
				while(EnterWhileLoop)
				{
				try{
				System.out.print("Enter member's Gender 'F' for female: ");
				gender = input.next().charAt(0);
				if (gender != 'F' && gender != 'f') 
                    throw new InvalidGenderException();
				EnterWhileLoop = false;
				}
				catch(InvalidGenderException ex )
				{
					System.out.println(ex);
				}
				}
				
		
				System.out.print("Enter member's membership Type 'G' for gold or 'S' for silver: ");
				char membershipType = input.next().charAt(0);
				input.nextLine();
				System.out.print("Enter member's weight goal: ");
				String Goal = input.nextLine() ;
				
				EnterWhileLoop = true ;
				int id = 0; 
				while(EnterWhileLoop)
				{
				try{
					System.out.print("Enter member's ID: ");
					id = input.nextInt();
				if (id <= 0) 
                    throw new InvalidIdException();
				EnterWhileLoop = false;
				}
				catch(InvalidIdException ex )
				{
					System.out.println(ex);
				}
				}

				Member newMember = new Member(name,age,gender,id,membershipType,Goal);
				if ( FitnessTime.addPerson(newMember) )
					System.out.println("Member is successfully added.");
				else
					System.out.println("Failed to add Member, Please check member information.");
				System.out.println("---------------------------------");
				break ;
					
			case 2:
				System.out.println("------------ Remove member ------------");
				EnterWhileLoop = true ;
				int Id = 0; 
				while(EnterWhileLoop)
				{
				try{
					System.out.print("Enter member's ID: ");
					Id = input.nextInt();
				if (Id <= 0) 
                    throw new InvalidIdException();
				EnterWhileLoop = false;
				}
				catch(InvalidIdException ex )
				{
					System.out.println(ex);
				}
				}
			
				if ( FitnessTime.removePerson(Id) )
					System.out.println("Member is Successfully removed");
				else
					System.out.println("Failed to remove Member, No member with ID: "+Id);
				System.out.println("----------------------------------------");
				break ;
				
			case 3:
				System.out.println("------------ Search member ------------");
				EnterWhileLoop = true ;
				int searchMemberID = 0; 
				while(EnterWhileLoop)
				{
				try{
					System.out.print("Enter Member's ID: ");
					searchMemberID = input.nextInt();
				if (searchMemberID <= 0) 
                    throw new InvalidIdException();
				EnterWhileLoop = false;
				}
				catch(InvalidIdException ex )
				{
					System.out.println(ex);
				}
				}

				if ( FitnessTime.searchPerson(searchMemberID) == -1 )
					System.out.println("No Member with ID: "+searchMemberID) ; 
				else {
					Person[] Peoplelist = FitnessTime.getPeopleList() ;
					System.out.println("Found Member with ID:"+ searchMemberID) ; 
					System.out.println("-------- Member INFO -----------") ; 
					Peoplelist[FitnessTime.searchPerson(searchMemberID)].toString(); 	
				}
				break ;

			case 4: 
				
				System.out.println("------------ Add trainer ------------");
				System.out.println("**Trainer have to be 23 years old or older with two or more years of experience**");
				System.out.print("Enter Trainer's Name: ");
				String TrainerName = input.next() ;
				
				EnterWhileLoop = true ;
				int TrainerAge = 0 ;
				while(EnterWhileLoop)
				{
				try{
					System.out.print("Enter Trainer's Age: ");
					TrainerAge = input.nextInt();
				if ( TrainerAge < 23 )
                    throw new InvalidAgeException("Age must be 23 years and older");
				EnterWhileLoop = false;
				}
				catch(InvalidAgeException ex )
				{
					System.out.println(ex);
				}
				}

				EnterWhileLoop = true ;
				char TrainerGender = 0 ;
				while(EnterWhileLoop)
				{
				try{
					System.out.print("Enter Trainer's Gender 'F' for female: ");
					TrainerGender = input.next().charAt(0);
				if ( TrainerGender != 'F' && TrainerGender != 'f')
                    throw new InvalidGenderException();
				EnterWhileLoop = false;
				}
				catch(InvalidGenderException ex )
				{
					System.out.println(ex);
				}
				}
			
				

				
				EnterWhileLoop = true ;
				int TrainerID = 0; 
				while(EnterWhileLoop)
				{
				try{
					System.out.print("Enter Trainer's ID: ");
					TrainerID = input.nextInt(); 
				if (TrainerID <= 0) 
                    throw new InvalidIdException();
				EnterWhileLoop = false;
				}
				catch(InvalidIdException ex )
				{
					System.out.println(ex);
				}
				}
				
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
				EnterWhileLoop = true ;
				int TrainerId = 0; 
				while(EnterWhileLoop)
				{
				try{
					System.out.print("Enter Trainer's ID: ");
					TrainerId= input.nextInt();
				if (TrainerId <= 0) 
                    throw new InvalidIdException();
				EnterWhileLoop = false;
				}
				catch(InvalidIdException ex )
				{
					System.out.println(ex);
				}
				}

				if ( FitnessTime.removePerson(TrainerId) )
					System.out.println("Trainer is Successfully removed");
				else
					System.out.println("Failed to remove Trainer, No Trainer with "+TrainerId+" ID");
				System.out.println("----------------------------------------");
				break ;	

				
			case 6:
				System.out.println("------------ Search Trainer ------------");
				EnterWhileLoop = true ;
				int searchTrainerID = 0; 
				while(EnterWhileLoop)
				{
				try{
					System.out.print("Enter Trainer's ID: ");
					searchTrainerID= input.nextInt();
				if (searchTrainerID <= 0) 
                    throw new InvalidIdException();
				EnterWhileLoop = false;
				}
				catch(InvalidIdException ex )
				{
					System.out.println(ex);
				}
				}

				if ( FitnessTime.searchPerson(searchTrainerID) == -1 )
					System.out.println("No Trainer with ID: "+searchTrainerID) ; 
				else {
					Person[] peoplelist = FitnessTime.getPeopleList() ;
					System.out.println("Found Trainer with ID: " + searchTrainerID) ; 
					System.out.println("-------- Trainer INFO -----------") ; 
					peoplelist[FitnessTime.searchPerson(searchTrainerID)].toString(); 	
				}
				break ;
			
             case 7: 
				
				System.out.println("------------ Add Employee ------------");
				System.out.println("**Employee have to be 21 years old or more**");
				System.out.print("Enter Employee's Name: ");
				String EmployeeName= input.next() ;
				
				EnterWhileLoop = true ;
				int EmployeeAge = 0 ;
				while(EnterWhileLoop)
				{
				try{
					System.out.print("Enter Employee's Age: ");
					EmployeeAge = input.nextInt();
				if ( EmployeeAge < 21 )
                    throw new InvalidAgeException("Age must be 21 years and older");
				EnterWhileLoop = false;
				}
				catch(InvalidAgeException ex )
				{
					System.out.println(ex);
				}
				}

				EnterWhileLoop = true ;
				char EmployeeGender = 0 ;
				while(EnterWhileLoop)
				{
				try{
					System.out.print("Enter Employee's Gender 'F' for female: ");
					EmployeeGender = input.next().charAt(0);
				if ( EmployeeGender != 'F' &&  EmployeeGender != 'f')
                    throw new InvalidGenderException();
				EnterWhileLoop = false;
				}
				catch(InvalidAgeException ex )
				{
					System.out.println(ex);
				}
				}

				EnterWhileLoop = true ;
				int EmployeeID = 0; 
				while(EnterWhileLoop)
				{
				try{
					System.out.print("Enter Employee's ID: ");
					EmployeeID= input.nextInt(); 
				if (EmployeeID <= 0) 
                    throw new InvalidIdException();
				EnterWhileLoop = false;
				}
				catch(InvalidIdException ex )
				{
					System.out.println(ex);
				}
				}

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
				EnterWhileLoop = true ;
				int EmployeeId = 0; 
				while(EnterWhileLoop)
				{
				try{
					System.out.print("Enter Employee's ID: ");
					EmployeeId = input.nextInt(); 
				if (EmployeeId <= 0) 
                    throw new InvalidIdException();
				EnterWhileLoop = false;
				}
				catch(InvalidIdException ex )
				{
					System.out.println(ex);
				}
				}

				if ( FitnessTime.removePerson(EmployeeId) )
					System.out.println("Employee is Successfully removed");
				else
					System.out.println("Failed to remove Employee, No Employee with "+EmployeeId+" ID");
				System.out.println("----------------------------------------");
				break ;
			
			case 9:
				System.out.println("------------ Search Employee ------------");
				EnterWhileLoop = true ;
				int searchEmployeeID = 0; 
				while(EnterWhileLoop)
				{
				try{
					System.out.print("Enter Employee's ID: ");
					searchEmployeeID = input.nextInt();
				if (searchEmployeeID <= 0) 
                    throw new InvalidIdException();
				EnterWhileLoop = false;
				}
				catch(InvalidIdException ex )
				{
					System.out.println(ex);
				}
				}

				if ( FitnessTime.searchPerson(searchEmployeeID) == -1 )
					System.out.println("No employee with ID: "+searchEmployeeID) ; 
				else {
					Person[] peopleList = FitnessTime.getPeopleList() ;
					System.out.println("Found Employee with ID: "+ searchEmployeeID) ; 
					System.out.println("-------- Employee INFO -----------") ; 
					peopleList[FitnessTime.searchPerson(searchEmployeeID)].toString(); 	
				}
				break ;
				
				
			case 10: 
				System.out.println("------------ Add Equipment ------------");
				System.out.print("Enter equipment name: " ) ;
				String EquipmentName = input.next(); 
				EnterWhileLoop = true ;
				int EquipmentID = 0; 
				while(EnterWhileLoop)
				{
				try{
					System.out.print("Enter equipment ID: " ) ;
					EquipmentID = input.nextInt(); 
				if (EquipmentID <= 0) 
                    throw new InvalidIdException();
				EnterWhileLoop = false;
				}
				catch(InvalidIdException ex )
				{
					System.out.println(ex);
				}
				}

				System.out.print("Enter equipment Type: " ) ;
				String EquipmentType = input.next();
				Equipment newEquipment = new Equipment(EquipmentName , EquipmentID, EquipmentType) ; 
				if(FitnessTime.addEquipment(newEquipment))
				System.out.println("Equipment is successfully added.");
				else
					System.out.println("Failed to add Equipment, there is no empty space.");
				System.out.println("---------------------------------");
				break; 
				
			case 11:
				System.out.println("------------ Remove Equipment ------------");
				EnterWhileLoop = true ;
				int EquipmentId = 0 ;
				while(EnterWhileLoop)
				{
				try{
					System.out.print("Enter Equipment ID: ");
					EquipmentId= input.nextInt();
				if (EquipmentId <= 0) 
                    throw new InvalidIdException();
				EnterWhileLoop = false;
				}
				catch(InvalidIdException ex )
				{
					System.out.println(ex);
				}
				}

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
					if(FitnessTime.searchEquipmentByType(searchEquipmentType))
						System.out.println("Found the Equipment.") ; 
					else
						System.out.println("The equipment does not exist.") ; 
				break ;
				case 'n' : case 'N' :
					System.out.print("Enter Equipment name:"); 
					String searchEquipmentName = input.next() ; 
					if(FitnessTime.searchEquipmentByName(searchEquipmentName))
						System.out.println("Found the Equipment.") ; 
					else 
						System.out.println("The equipment does not exist ") ; 
				break;
	
				}
				System.out.println("---------------------------------");
				break;
			
				
				
			case 13:
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
			
			case 14:
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
				
				
			case 15:
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
			case 16:
         FitnessTime.Display() ; 

			}
			         

		}while (choice != 17);
	

}
 public static void saveGymInfo(Gym gym) {
        try {
            FileOutputStream fos = new FileOutputStream("gym_info.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(gym);
            oos.close();
            System.out.println("Save all information is done.");
        } catch (IOException e) {
            System.out.println("Error in saving gym information: " + e.getMessage());
        }
    }

    public static Gym loadGymInfo() {
        Gym gym = null;
        try {
            FileInputStream fis = new FileInputStream("gym_info.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            gym = (Gym) ois.readObject();
            ois.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Error while reading gym information: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error while loading the gym file: " + e.getMessage());
        }
        return gym;
    }
}
