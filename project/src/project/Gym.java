package project;

public class Gym {
	
        private String name;
	private String location;
	private Person [] pList;
	private Equipment [] eqList;
	private Employee [] empList;
	private int numOfPeople;
	private int numOfEquipment;
	private int numOfEmployee;

	
	public Gym(String name, String location, int maxPeople , int maxEquipment , int maxEmployee) {
		this.name = name;
		this.location = location;
		pList=new Person[maxPeople];
		eqList=new Equipment[maxEquipment];
		empList=new Employee[maxEmployee];
		numOfPeople=0;
		numOfEquipment=0;
		numOfEmployee=0;
	}
	
	
	public boolean addPerson (Person p) {
	
	if(numOfPeople<pList.length) {
	
			if(p instanceof Member) {
				if(p.getGender()=='F' && p.getAge()>=16)
				pList[numOfPeople++]=new Member(p.getName(), p.getAge(), p.getGender(), p.getID(), ((Member)p).getMembershipType(), ((Member)p).getGoal());}
			else if(p instanceof Trainer) {
				if(p.getGender()=='F' && p.getAge()>=23)
				pList[numOfPeople++] = new Trainer(p.getName(), p.getAge(), p.getGender(), p.getID(), ((Trainer)p).getExperienceYears()); }
				return true;
	}
	return false; 
	}

	
	public int searchPerson(int id){
		for(int i=0 ; i<numOfPeople ; i++){
		    if(pList[i].getID()==id)		 
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
	
	
	
	
	public boolean addEquipment(Equipment eq) {
		if(numOfEquipment<eqList.length) {
			eqList[numOfEquipment++]=eq;
		return true;
		}
		return false;
	}
	
	
	
	public Equipment[] searchEquipmentByName (String name) {
		
		Equipment[] eqName=new Equipment[numOfEquipment];
		int j=0;
		for(int i=0; i<numOfEquipment; i++) 
			if(eqList[i].getName().equalsIgnoreCase(name))
			eqName[j++]=eqList[i];
		
		if(j==0)
			return null;
		else 
			return eqName;
	}
	
	
	
	public Equipment[] searchEquipmentByType (String type) {
		Equipment[] eqType=new Equipment[numOfEquipment];
		int j=0;
		for(int i=0; i<numOfEquipment; i++) 
			if(eqList[i].getType().equalsIgnoreCase(type))
			eqType[j++]=eqList[i];
		
		if(j==0)
			return null;
		else 
			return eqType;
	}


	public boolean addEmployee (Employee emp) {
		
		if(numOfEmployee<empList.length) {
		if(emp.getGender()=='F' && emp.getAge()>=21)
		empList[numOfEmployee++]=new Employee(emp.getName(), emp.getAge(), emp.getGender(), emp.getworkinHoures(), emp.getID());
		return true;
		}
		return false; 
		}

	
	public int searchEmployee(int id){
		for(int i=0;i<numOfEmployee;i++){
		    if(empList[i].getID()==id)
		return i ;
		}
		return -1 ;
	}
	
	
	public boolean removeEmployee(int id) {
		int loc=searchEmployee(id);
	    if(loc<numOfEmployee && loc>=0){
	       for(int i=loc;i<numOfEmployee-1;i++) 
	       empList[i]=empList[i+1];
	    
	       empList[--numOfEmployee]=null;
	       return true;
	    }
           return false;
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
		  System.out.println("Gym Name: " + name + "\nLocation: "+ location + "\nNumber of Employees: "+ numOfEmployee +"\nNumber of Members: "+getNumOfMembers()+"\nNumber of Trainers: "+ getNumOfTrainers() );
		  //display employees INFO
		  System.out.println("-----Employees INFO-------");
		  for(int i=0 ; i< numOfEmployee ; i++)
		    empList[i].Print() ;
		  //display members INFO
		  System.out.println("-----Members INFO-------");
		  for(int i=0 ; i< numOfPeople ; i++)
		   if ( pList[i] instanceof Member )
		    pList[i].Print() ;
		  //display Trainers INFO
		  System.out.println("-----Trainers INFO-------");
		  for(int i=0 ; i< numOfPeople ; i++)
		   if ( pList[i] instanceof Trainer )
		    pList[i].Print() ;
		  //display Equipments INFO 
		  System.out.println("-----Equipments INFO-------");
		  for(int i=0 ; i< numOfEquipment ; i++)
		   System.out.print(eqList[i]);

		   }
}
