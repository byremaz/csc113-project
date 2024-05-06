package project;

public class InvalidAgeException extends RuntimeException{
	
	
	 public InvalidAgeException() {
	        super("Invalid age value. Enter a valid age value.");
	    }
	    
	    public InvalidAgeException(String string) {
	        super(string);
	    }
	


}
