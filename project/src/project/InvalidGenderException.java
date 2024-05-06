package project;

public class InvalidGenderException extends RuntimeException {

	
	public InvalidGenderException() {
		
		super("Gender must be a Female 'F' ") ;
		
	}
	
	public InvalidGenderException(String string) {
		
		super(string) ;
		
	}
	
	
}
