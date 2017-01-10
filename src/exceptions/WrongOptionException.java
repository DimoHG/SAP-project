package exceptions;

public class WrongOptionException extends Exception {
	
	
	@Override
	public String getMessage(){
		return "No such option";
	}
}
