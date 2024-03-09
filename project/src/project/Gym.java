package project;

public class Gym {

	private String name;
	private String location;
	private Person [] pList;
	private Equipment [] eList;
	private int numOfPeople;
	private int numOfEquipment;
	
	public Gym(String name, String location, int maxPeople , int maxEquipment ) {
		this.name = name;
		this.location = location;
		pList=new Person[maxPeople];
		eList=new Equipment[maxEquipment];
		numOfPeople=0;
		numOfEquipment=0;
	}
	
	
	public boolean addPerson (Person p) {
	
	if(numOfPeople<pList.length) {
	
			if(p instanceof Member)
				pList[numOfPeople++]=new Member(p.getName(), p.getAge(), p.getGender(), ((Member)p).getMemberID(), ((Member)p).getMembershipType(), ((Member)p).getGoal());
			else if(p instanceof Trainer)
				pList[numOfPeople++] = new Trainer(p.getName(), p.getAge(), p.getGender(), ((Trainer)p).getTrainerID(), ((Trainer)p).getExperienceYears()); 
				return true;
	}
	return false; 
	}

	
	public int searchPerson(int id){
		for(int i=0 ; i<numOfPeople ; i++){
		    if(((Member)pList[i]).getMemberID()==id)
		    	return i ;
		    else if(((Trainer)pList[i]).getTrainerID()==id)
		    	return i ;
		}
		return -1 ;
	}

	
	public boolean removePerson(int id) {
		int loc=searchPerson(id);
	    if(loc<numOfPeople && loc>=0){
	       for(int i=loc;i<numOfPeople-1;i++) 
	       pList[i]=pList[i+1];
	    
	       pList[--numOfPeople]=null;
	       return true;
	    }
           return false;
	}
	
	
	
	
	public boolean addEquipment(Equipment e) {
		if(numOfEquipment<eList.length) {
			eList[numOfEquipment++]=e;
		return true;
		}
		return false;
	}
	
	
	
	public Equipment[] searchEquipmentByName (String name) {
		
		Equipment[] eName=new Equipment[numOfEquipment];
		int j=0;
		for(int i=0; i<numOfEquipment; i++) 
			if(eList[i].getName().equalsIgnoreCase(name))
			eName[j++]=new Equipment(eList[i].getName(),eList[i].getType(),eList[i].getQuantity());
		
		if(j==0)
			return null;
		else 
			return eName;
	}
	
	
	
	public Equipment[] searchEquipmentByType (String type) {
		Equipment[] eType=new Equipment[numOfEquipment];
		int j=0;
		for(int i=0; i<numOfEquipment; i++) 
			if(eList[i].getType().equalsIgnoreCase(type))
			eType[j++]=new Equipment(eList[i].getName(),eList[i].getType(),eList[i].getQuantity());
		
		if(j==0)
			return null;
		else 
			return eType;
	}

	public int getNumOfMembers() {
		int num = 0 ;
		
		for ( int i = 0 ; i < numOfPeople ; i++ ) {
			if ( pList[i] instanceof Member )
				num++ ;
		}
		
		return num ;
	}
	
	public int getNumOfTrainers() {
		int num = 0 ;
		
		for ( int i = 0 ; i < numOfPeople ; i++ ) {
			if ( pList[i] instanceof Trainer )
				num++ ;
		}
		
		return num ;
	}
	
	public void Display() {
		
		System.out.println("--------------Gym's information---------------"); 
		System.out.println("Gym Name: " + name + " Location: "+ location +" Number of Members: "+getNumOfMembers()+" Number of Trainers: "+ getNumOfTrainers() );
		//display members info
		System.out.println("-----Members INFO-------");
		for(int i=0 ; i< numOfPeople ; i++)
			if ( pList[i] instanceof Member )
				pList[i].Print() ;
		//display Trainers INFO
		System.out.println("-----Trainers INFO-------");
		for(int i=0 ; i< numOfPeople ; i++)
			if ( pList[i] instanceof Trainer )
				pList[i].Print() ;
		//display Equipments info 
		System.out.println("-----Equipments INFO-------");
		for(int i=0 ; i< numOfEquipment ; i++)
			System.out.print(eList[i]);

			}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
