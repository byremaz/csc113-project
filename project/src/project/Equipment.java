package project;

public class Equipment {
	
	private String Name ;
	private String Type ;
	private int Quantity ;
	private int ID ;
	
	public Equipment(String name, String type, int quantity, int id) {
		Name = name;
		Type = type;
		Quantity = quantity;
		ID = id ;
	}

	public String getName() {
		return Name;
	}

	public String getType() {
		return Type;
	}

	public int getQuantity() {
		return Quantity;
	}

	public String toString() {
		
		return "Equipment Name: " + Name + " Type:" + Type + " Quantity: "+ Quantity + " ID: " + ID+ "\n";
	
	}

	public int getID() {
		return ID;
	}

	
	
}
