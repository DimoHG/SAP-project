package exceptions;

public class NoSuchEventException extends Exception {
	
	
	@Override
	public String getMessage(){
		return "No such event in the database";
	}

}
