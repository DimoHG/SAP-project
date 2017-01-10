package enums;

import java.util.Scanner;

import exceptions.NoSuchMarkerException;

public enum EventMarker {
PUBLIC("Public"),
CONFIDENTIAL("Confidential"),
PRIVATE("Private");
	
	private final String marker;

	EventMarker(String marker){
	this.marker=marker;	
	}
	
	public String getMarker(){
		return this.marker;
	}
	

	
	public static EventMarker markerValidation(String userInput) throws NoSuchMarkerException{
		
		userInput=userInput.toLowerCase();
		if(userInput.equals("public")){
			EventMarker publicMarker=EventMarker.PUBLIC;
			return publicMarker;
		}else if(userInput.equals("confidential")){
			EventMarker confidentialMarker=EventMarker.CONFIDENTIAL;
			return confidentialMarker;
		}else if(userInput.equals("private")){
			EventMarker privateMarker=EventMarker.PRIVATE;
			return privateMarker;
		}else throw new NoSuchMarkerException();
	
}

}
	
	
	
	
	
	
	