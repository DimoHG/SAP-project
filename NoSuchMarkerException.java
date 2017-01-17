package exceptions;

public class NoSuchMarkerException extends Exception {
	
	@Override
	public String getMessage(){
		return "No such marker";
	}
}
