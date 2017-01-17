package exceptions;

public class NoSuchTypeException extends Exception {

	@Override
	public String getMessage(){
		return "No such type";
	}
}
