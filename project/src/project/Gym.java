package project;

import java.io.Serializable;

public class Gym implements Serializable{
	
        private String Name;
	private String Location;
	private Person [] peopleList;
	private Equipment [] equipmentList;
	private int NumOfPeople;
	private int NumOfEquipment;

	
	public Gym(String name, String location, int maxPeople , int maxEquipment) {
		Name = name;
		Location = location;
		peopleList=new Person[maxPeople];
		equipmentList=new Equipment[maxEquipment];
		NumOfPeople=0;
		NumOfEquipment=0;
	}
	
	
public boolean addPerson (Person person) {
if(NumOfPeople<peopleList.length) {

	if(person instanceof Member) {
	    if((person.getGender() == 'F' || person.getGender() == 'f') && person.getAge() >= 16) {
	        peopleList[NumOfPeople++] = new Member(person.getName(), person.getAge(), person.getGender(), person.getID(), ((Member)person).getMembershipType(), ((Member)person).getGoal());
	        return true;
	    }
	}
	else if(person instanceof Trainer) {
	    if((person.getGender() == 'F' || person.getGender() == 'f') && person.getAge() >= 23 && ((Trainer)person).getExperienceYears()>=2) {
	        peopleList[NumOfPeople++] = new Trainer(person.getName(), person.getAge(), person.getGender(), person.getID(), ((Trainer)person).getExperienceYears());
	        return true;
	    }
	}
	else if(person instanceof Employee) {
	    if((person.getGender() == 'F' || person.getGender() == 'f') && person.getAge() >= 21) {
	        peopleList[NumOfPeople++] = new Employee(person.getName(), person.getAge(), person.getGender(), ((Employee)person).getworkHours(), person.getID());
	        return true;
	    }
	}
}
return false; 
}

	
	public int searchPerson(int id){
		for(int i=0 ; i<NumOfPeople ; i++)
		    if(peopleList[i].getID()==id)		 
		    return i ;
		
		return -1 ; 
	}
	

	
	public boolean removePerson(int id) {
	       for(int i=0;i<NumOfPeople;i++) 
	    	   if(peopleList[i].getID()==id) {
	       peopleList[i]=peopleList[NumOfPeople-1];
	       peopleList[--NumOfPeople]=null;
	       return true;
	    }
           return false;
	}
	
	
	
	
	public boolean addEquipment(Equipment equipment) {
		if(NumOfEquipment<equipmentList.length) {
			equipmentList[NumOfEquipment++]=equipment;
		return true;
		}
		return false;
	}
	
	
	
	public boolean searchEquipmentByName (String name) {
	for(int i=0; i<NumOfEquipment; i++) 
		if(equipmentList[i].getName().equalsIgnoreCase(name))
      return true;
	
		return false;
}



public boolean searchEquipmentByType (String type) {
	for(int i=0; i<NumOfEquipment; i++) 
		if(equipmentList[i].getType().equalsIgnoreCase(type))	
		return true;
	 
		return false;
}
	
	
	public boolean removeEquipment(int id) {
	       for(int i=0;i<NumOfEquipment;i++) 
	    	   if(equipmentList[i].getID()==id) {
	    		   equipmentList[i]=equipmentList[NumOfEquipment-1];
	    		   equipmentList[--NumOfEquipment]=null;
	       return true;
	    }
        return false;
	}

	
	public Person[] getEmployees(){
		Person [] employeeList=new Person[NumOfPeople];
		int j=0;
		for(int i=0;i<NumOfPeople;i++)
		    if(peopleList[i] instanceof Employee)
		    	employeeList[j++]=new Employee(peopleList[i].getName(), peopleList[i].getAge(), peopleList[i].getGender(), ((Employee)peopleList[i]).getworkHours(), peopleList[i].getID());
		
		return employeeList;
	}
	
	
	public Person[] getMembers(){
		Person [] memberList=new Person[NumOfPeople];
		int j=0;
		for(int i=0;i<NumOfPeople;i++)
		    if(peopleList[i] instanceof Member)
		    	memberList[j++]=new Member(peopleList[i].getName(), peopleList[i].getAge(), peopleList[i].getGender(), peopleList[i].getID(), ((Member)peopleList[i]).getMembershipType(), ((Member)peopleList[i]).getGoal());
		
		return memberList;
	}

	
	public Person[] getTrainers(){
		Person [] trainerList=new Person[NumOfPeople];
		int j=0;
		for(int i=0;i<NumOfPeople;i++)
		    if(peopleList[i] instanceof Trainer)
		    	trainerList[j++]=new Trainer(peopleList[i].getName(), peopleList[i].getAge(), peopleList[i].getGender(), peopleList[i].getID(), ((Trainer)peopleList[i]).getExperienceYears());
		
		return trainerList;
	}

	

	
	public int getNumOfMembers() {
		int num = 0 ;
		
		for ( int i = 0 ; i < NumOfPeople ; i++ ) {
			if ( peopleList[i] instanceof Member )
				num++ ;
		}
		
		return num ;
	}
	
	public int getNumOfTrainers() {
		int num = 0 ;
		
		for ( int i = 0 ; i < NumOfPeople ; i++ ) {
			if ( peopleList[i] instanceof Trainer )
				num++ ;
		}
		
		return num ;
	}

	public int getNumOfEmployees() {
		int num = 0 ;
		
		for ( int i = 0 ; i < NumOfPeople ; i++ ) {
			if ( peopleList[i] instanceof Employee )
				num++ ;
		}
		
		return num ;
	}


	public Person[] getPeopleList() {
		return peopleList;
	}

	
	 public void Display() {
		  
		  System.out.println("--------------Gym's information---------------"); 
		  System.out.println("Gym Name: " + Name + "\nLocation: "+ Location + "\nNumber of Employees: "+ getNumOfEmployees() +"\nNumber of Members: "+getNumOfMembers()+"\nNumber of Trainers: "+ getNumOfTrainers() );
		  //display employees INFO
		  System.out.println("-----Employees INFO-------");
		   for(int i=0 ; i< NumOfPeople ; i++)
		   if ( peopleList[i] instanceof Employee )
		    peopleList[i].Print() ;
		  //display members INFO
		  System.out.println("-----Members INFO-------");
		  for(int i=0 ; i< NumOfPeople ; i++)
		   if ( peopleList[i] instanceof Member )
		    peopleList[i].Print() ;
		  //display Trainers INFO
		  System.out.println("-----Trainers INFO-------");
		  for(int i=0 ; i< NumOfPeople ; i++)
		   if ( peopleList[i] instanceof Trainer )
		    peopleList[i].Print() ;
		  //display Equipments INFO 
		  System.out.println("-----Equipments INFO-------");
		  for(int i=0 ; i< NumOfEquipment ; i++)
		   System.out.print(equipmentList[i]);

		   }        
}
