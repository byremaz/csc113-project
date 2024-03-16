package project;

public class Equipment {
	
	private String Name ;
	private int ID ;
	private String Type ;
	
	public Equipment(String name, int id, String type, int quantity) {
		Name = name;
		ID = id ;
		Type = type;
		Quantity = quantity;
	}

	public String getName() {
		return Name;
	}

	public String getType() {
		return Type;
	}
	
	public int getID() {
		return ID;
	}
	
	public String toString() {
		
		return "Equipment Name: " + Name + " ID: " + ID+" Type:" + Type + " Quantity: "+ Quantity + "\n";
	
	}



	
	
}
