package project;

public class Equipment {
	
	private String Name ;
	private String Type ;
	private int Quantity ;
	
	public Equipment(String name, String type, int quantity) {
		Name = name;
		Type = type;
		Quantity = quantity;
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
		
		return "Equipment Name: " + Name + " Type:" + Type + " Quantity: "+ Quantity + "\n";
	
	}

}
