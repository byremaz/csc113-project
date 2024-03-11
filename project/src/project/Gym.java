package project;

public class Gym {
	
        private String Name;
	private String Location;
	private Person [] pList;
	private Equipment [] eqList;
	private int NumOfPeople;
	private int NumOfEquipment;

	
	public Gym(String name, String location, int maxPeople , int maxEquipment) {
		Name = name;
		Location = location;
		pList=new Person[maxPeople];
		eqList=new Equipment[maxEquipment];
		NumOfPeople=0;
		NumOfEquipment=0;
	}
	
	
	public boolean addPerson (Person p) {
	
	if(NumOfPeople<pList.length) {
	
			if(p instanceof Member) {
				if(p.getGender()=='F' && p.getAge()>=16)
				pList[NumOfPeople++]=new Member(p.getName(), p.getAge(), p.getGender(), p.getID(), ((Member)p).getMembershipType(), ((Member)p).getGoal());}
			else if(p instanceof Trainer) {
				if(p.getGender()=='F' && p.getAge()>=23)
				pList[NumOfPeople++] = new Trainer(p.getName(), p.getAge(), p.getGender(), p.getID(), ((Trainer)p).getExperienceYears()); }
		else if(p instanceof Employee) {
				if(p.getGender()=='F' && p.getAge()>=21)
				pList[NumOfPeople++] = new Employee(p.getName(), p.getAge(), p.getGender(), ((Employee)p).getworkHours(), p.getID()); }
				return true;
	}
	return false; 
	}

	
	public int searchPerson(int id){
		for(int i=0 ; i<NumOfPeople ; i++){
		    if(pList[i].getID()==id)		 
		    return i ;
		}
		return -1 ; 
	}

	
	public boolean removePerson(int id) {
		int loc=searchPerson(id);
	    if(loc<NumOfPeople && loc>=0){
	       for(int i=loc;i<NumOfPeople-1;i++) 
	       pList[i]=pList[i+1];
	    
	       pList[--NumOfPeople]=null;
	       return true;
	    }
           return false;
	}
	
	
	
	
	public boolean addEquipment(Equipment eq) {
		if(NumOfEquipment<eqList.length) {
			eqList[NumOfEquipment++]=eq;
		return true;
		}
		return false;
	}
	
	
	
	public Equipment[] searchEquipmentByName (String name) {
		
		Equipment[] eqName=new Equipment[NumOfEquipment];
		int j=0;
		for(int i=0; i<NumOfEquipment; i++) 
			if(eqList[i].getName().equalsIgnoreCase(name))
			eqName[j++]=eqList[i];
		
		if(j==0)
			return null;
		else 
			return eqName;
	}
	
	
	
	public Equipment[] searchEquipmentByType (String type) {
		Equipment[] eqType=new Equipment[NumOfEquipment];
		int j=0;
		for(int i=0; i<NumOfEquipment; i++) 
			if(eqList[i].getType().equalsIgnoreCase(type))
			eqType[j++]=eqList[i];
		
		if(j==0)
			return null;
		else 
			return eqType;
	}

	
	public Person[] getEmployees(){
		Person [] empList=new Person[NumOfPeople];
		int j=0;
		for(int i=0;i<NumOfPeople;i++)
		    if(pList[i] instanceof Employee)
		    	empList[j++]=new Employee(pList[i].getName(), pList[i].getAge(), pList[i].getGender(), ((Employee)pList[i]).getworkHours(), pList[i].getID());
		
		return empList;
	}
	
	public Person[] getMembers(){
		Person [] mList=new Person[NumOfPeople];
		int j=0;
		for(int i=0;i<NumOfPeople;i++)
		    if(pList[i] instanceof Member)
		    	mList[j++]=new Member(pList[i].getName(), pList[i].getAge(), pList[i].getGender(), pList[i].getID(), ((Member)pList[i]).getMembershipType(), ((Member)pList[i]).getGoal());
		
		return mList;
	}

	public Person[] getTrainers(){
		Person [] tList=new Person[NumOfPeople];
		int j=0;
		for(int i=0;i<NumOfPeople;i++)
		    if(pList[i] instanceof Trainer)
		    	tList[j++]=new Trainer(pList[i].getName(), pList[i].getAge(), pList[i].getGender(), pList[i].getID(), ((Trainer)pList[i]).getExperienceYears());
		
		return tList;
	}

	

	
	public int getNumOfMembers() {
		int num = 0 ;
		
		for ( int i = 0 ; i < NumOfPeople ; i++ ) {
			if ( pList[i] instanceof Member )
				num++ ;
		}
		
		return num ;
	}
	
	public int getNumOfTrainers() {
		int num = 0 ;
		
		for ( int i = 0 ; i < NumOfPeople ; i++ ) {
			if ( pList[i] instanceof Trainer )
				num++ ;
		}
		
		return num ;
	}

	public int getNumOfEmployees() {
		int num = 0 ;
		
		for ( int i = 0 ; i < NumOfPeople ; i++ ) {
			if ( pList[i] instanceof Employee )
				num++ ;
		}
		
		return num ;
	}
	
	 public void Display() {
		  
		  System.out.println("--------------Gym's information---------------"); 
		  System.out.println("Gym Name: " + Name + "\nLocation: "+ Location + "\nNumber of Employees: "+ getNumOfEmployees() +"\nNumber of Members: "+getNumOfMembers()+"\nNumber of Trainers: "+ getNumOfTrainers() );
		  //display employees INFO
		  System.out.println("-----Employees INFO-------");
		   for(int i=0 ; i< NumOfPeople ; i++)
		   if ( pList[i] instanceof Employee )
		    pList[i].Print() ;
		  //display members INFO
		  System.out.println("-----Members INFO-------");
		  for(int i=0 ; i< NumOfPeople ; i++)
		   if ( pList[i] instanceof Member )
		    pList[i].Print() ;
		  //display Trainers INFO
		  System.out.println("-----Trainers INFO-------");
		  for(int i=0 ; i< NumOfPeople ; i++)
		   if ( pList[i] instanceof Trainer )
		    pList[i].Print() ;
		  //display Equipments INFO 
		  System.out.println("-----Equipments INFO-------");
		  for(int i=0 ; i< NumOfEquipment ; i++)
		   System.out.print(eqList[i]);

		   }
}
