package project;

import java.io.Serializable;


public class Equipment implements Serializable{
	
	private String Name ;
	private int ID ;
	private String Type ;
	
	public Equipment(String name, int id, String type) {
		Name = name;
		ID = id ;
		Type = type;
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
		
		return "Equipment Name: " + Name + " ID: " + ID+" Type:" + Type + "\n";
	
	}



	
	
}
